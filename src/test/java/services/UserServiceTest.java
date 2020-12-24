package services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import dao.impl.UserDaoImpl;

import static services.TestData.getUser;
import static services.TestData.getUserList;

import entities.User;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserDaoImpl dao;

    @InjectMocks
    private UserService userService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll_ReturnUsers() {
        List<User> list = getUserList();
        when(dao.findAll()).thenReturn(list);

        assertEquals(userService.findAll(), list);
    }

    @Test
    public void testFindById_ValidId_ReturnUser() {
        User user = getUser();
        when(dao.findById(3)).thenReturn(user);

        assertEquals(userService.findById(3), user);
    }

    @Test
    public void testAdd_ValidUser_VerifyInvocationsNumber() {
        User user = getUser();
        userService.add(user);

        verify(dao, times(1)).add(user);
    }

    @Test
    public void testDelete_ValidUser_VerifyInvocationsNumber() {
        User user = getUser();
        userService.delete(user);

        verify(dao, times(1)).delete(user);
    }
}