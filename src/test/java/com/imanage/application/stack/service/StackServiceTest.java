package com.imanage.application.stack.service;

import com.imanage.application.stack.exceptions.StackOverflowException;
import com.imanage.application.stack.exceptions.StackUnderflowException;
import com.imanage.application.stack.repository.StackRepository;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Nidhi Gautam 4/18/21
 */

@SpringBootTest
public class StackServiceTest {
    private StackRepository stackRepository = Mockito.mock(StackRepository.class);
    private StackService stackService = new StackService(stackRepository);

    @Test
    public void testPeek_success() throws StackUnderflowException {
        Mockito.when(stackRepository.peek()).thenReturn(123);
        Integer ele = stackService.peek();
        Assert.assertNotNull(ele);
    }

    @Test
    public void testPeek_withException() {
        try {
            stackService.peek();
        } catch (StackUnderflowException se) {
            Assert.assertNotNull(se);
        }
    }

    @Test
    public void testPop_success() throws StackUnderflowException {
        Mockito.when(stackRepository.pop()).thenReturn(123);
        Integer ele = stackService.pop();
        Assert.assertNotNull(ele);

    }

    @Test
    public void testPop_withException() {
        try {
            stackService.pop();
        } catch (StackUnderflowException se) {
            Assert.assertNotNull(se);
        }
    }

    @Test
    public void testPush_success() throws StackOverflowException {
        Mockito.when(stackRepository.push(Mockito.anyInt())).thenReturn(true);
        boolean isPushed = stackService.push(123);
        Assert.assertTrue(isPushed);

    }

    @Test
    public void testPush_withException() throws StackOverflowException {
        Mockito.when(stackRepository.push(Mockito.anyInt())).thenThrow(StackOverflowException.class);
        try {
            stackService.pop();
        } catch (StackUnderflowException se) {
            Assert.assertNotNull(se);
        }
    }
}
