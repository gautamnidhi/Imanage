package com.imanage.application.stack.controller;

import com.imanage.application.stack.exceptions.StackOverflowException;
import com.imanage.application.stack.exceptions.StackUnderflowException;
import com.imanage.application.stack.service.StackService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Nidhi Gautam 4/18/21
 */

@SpringBootTest
public class StackControllerTest {
    private StackService stackService = Mockito.mock(StackService.class);
    private StackController stackController = new StackController(stackService);

    @Test
    public void testPeek_success() throws StackUnderflowException {
        Mockito.when(stackService.peek()).thenReturn(123);
        Integer ele = stackController.get();
        Assert.assertNotNull(ele);
    }

    @Test
    public void testPeek_withException() {
        try {
            stackController.get();
        } catch (StackUnderflowException se) {
            Assert.assertNotNull(se);
        }
    }

    @Test
    public void testPop_success() throws StackUnderflowException {
        Mockito.when(stackService.pop()).thenReturn(123);
        Integer ele = stackController.pop();
        Assert.assertNotNull(ele);

    }

    @Test
    public void testPop_withException() {
        try {
            stackController.pop();
        } catch (StackUnderflowException se) {
            Assert.assertNotNull(se);
        }
    }

    @Test
    public void testPush_success() throws StackOverflowException {
        Mockito.when(stackService.push(Mockito.anyInt())).thenReturn(true);
        boolean isPushed = stackController.push(123);
        Assert.assertTrue(isPushed);

    }

    @Test
    public void testPush_withException() throws StackOverflowException {
        Mockito.when(stackService.push(Mockito.anyInt())).thenThrow(StackOverflowException.class);
        try {
            stackController.pop();
        } catch (StackUnderflowException se) {
            Assert.assertNotNull(se);
        }
    }

}
