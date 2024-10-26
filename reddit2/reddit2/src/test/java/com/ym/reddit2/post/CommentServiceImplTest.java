package com.ym.reddit2.post;

import com.ym.reddit2.models.Comment;
import com.ym.reddit2.repository.CommentRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class CommentServiceImplTest {

    @Mock
    postService postSerMock;

    @Mock
    CommentRepo commentRepoMock;

    @Mock
    PageRequest pageRequestMock;

    @InjectMocks
    CommentServiceImpl commentService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void addUserComment() {
        Comment comment = new Comment("1","1","1","1");
        when(postSerMock.checkPostExist(comment.getPostId())).thenReturn(true);
        when(postSerMock.checkUserExist(1)).thenReturn(true);
        when(commentRepoMock.save(comment)).thenReturn(null);
        commentService.addUserComment(comment);
    }

    @Test
    void deleteUserComment() {
        commentService.deleteUserComment("1","1");
    }

    @Test
    void getCommentsOnPost() {
        Comment comment = new Comment("1","1","1","1");
        when(postSerMock.checkPostExist(comment.getPostId())).thenReturn(true);
        List<Comment> mockList  = new ArrayList<>();
        IntStream.range(0,4)
                .boxed().map(i->i.toString()).forEach(a-> mockList.add(new Comment(a,a,a,a)));
//        mockList.stream().forEach(System.out::println);
        when(commentRepoMock.findAll("1")).thenReturn(mockList);
        List<Comment> commentsOnPost = commentService.getCommentsOnPost("1");
        assertEquals(4,commentsOnPost.size());
    }

    @Test
    void getPaginatedProducts() {
//        List<Comment> mockList  = new ArrayList<>();
//        IntStream.range(0,4)
//                .boxed().map(i->i.toString()).forEach(a-> mockList.add(new Comment(a,a,a,a)));
////        mockList.stream().forEach(System.out::println);
//        when(commentRepoMock.findAll("1")).thenReturn(mockList);
//        try (MockedStatic<PageRequest> mockStatic = mockStatic(PageRequest.class)) {
//            // Define behavior for the static method, here it does nothing
//            mockStatic.when(() -> NotificationUtil.logNotification(anyString(), anyString()))
//                    .thenReturn();
//
//            // Act: Call the method being tested
//            userService.updateUser("123");
//
//            // Assert: Verify the static method was called with specific arguments
//            mockStatic.verify(() -> PageRequest.of("1", "User updated successfully."));
//        }
//        Page<Comment> paginatedProducts = commentService.getPaginatedProducts(1, 1);
//        assertTrue(4 == paginatedProducts.getSize());
    }
}