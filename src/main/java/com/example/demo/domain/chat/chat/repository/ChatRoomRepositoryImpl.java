package com.example.demo.domain.chat.chat.repository;

import com.example.demo.domain.chat.chat.entity.ChatRoom;
import com.example.demo.domain.member.member.entity.Member;
import com.example.demo.standard.base.KwTypeV2;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.support.PageableExecutionUtils;

import static com.example.demo.domain.chat.chat.entity.QChatRoom.chatRoom;

@RequiredArgsConstructor
public class ChatRoomRepositoryImpl implements ChatRoomRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<ChatRoom> findByKw(KwTypeV2 kwType, String kw, Member owner, Boolean published, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();

        if (owner != null) {
            builder.and(chatRoom.owner.eq(owner));
        }

        if (published != null) {
            builder.and(chatRoom.published.eq(published));
        }

        if (kw != null && !kw.isBlank()) {
            applyKeywordFilter(kwType, kw, builder);
        }

        JPAQuery<ChatRoom> itemsQuery = createPostsQuery(builder);
        applySorting(pageable, itemsQuery);

        itemsQuery.offset(pageable.getOffset()).limit(pageable.getPageSize());

        JPAQuery<Long> totalQuery = createTotalQuery(builder);

        return PageableExecutionUtils.getPage(itemsQuery.fetch(), pageable, totalQuery::fetchOne);
    }

    private void applyKeywordFilter(KwTypeV2 kwType, String kw, BooleanBuilder builder) {
        switch (kwType) {
            case kwType.NAME -> builder.and(chatRoom.name.containsIgnoreCase(kw));
            case kwType.OWNER -> builder.and(chatRoom.owner.nickname.containsIgnoreCase(kw));
            default -> builder.and(
                    chatRoom.name.containsIgnoreCase(kw)
                            .or(chatRoom.owner.nickname.containsIgnoreCase(kw))
            );
        }
    }

    private JPAQuery<ChatRoom> createPostsQuery(BooleanBuilder builder) {
        return jpaQueryFactory
                .select(chatRoom)
                .from(chatRoom)
                .where(builder);
    }

    private void applySorting(Pageable pageable, JPAQuery<ChatRoom> postsQuery) {
        for (Sort.Order o : pageable.getSort()) {
            PathBuilder pathBuilder = new PathBuilder(chatRoom.getType(), chatRoom.getMetadata());
            postsQuery.orderBy(new OrderSpecifier(o.isAscending() ? Order.ASC : Order.DESC, pathBuilder.get(o.getProperty())));
        }
    }

    private JPAQuery<Long> createTotalQuery(BooleanBuilder builder) {
        return jpaQueryFactory
                .select(chatRoom.count())
                .from(chatRoom)
                .where(builder);
    }
}
