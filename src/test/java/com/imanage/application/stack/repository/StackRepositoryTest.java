package com.imanage.application.stack.repository;

import com.imanage.application.stack.exceptions.StackOverflowException;
import com.imanage.application.stack.exceptions.StackUnderflowException;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

/**
 * @author Nidhi Gautam 4/18/21
 */

@TestPropertySource("classpath:src/main/resources/application.properties")
@SpringBootTest
public class StackRepositoryTest {

    private StackRepository stackRepository = new StackRepository();

    @Test
    public void testPeek_success() throws StackUnderflowException, StackOverflowException {
        Integer ele = 123;
        stackRepository.push(ele);
        Integer element = stackRepository.peek();
        Assert.assertEquals(ele, element);

    }

    @Test
    public void testPeek_withException() throws StackUnderflowException {
        Integer element = 0;
        try {
            element = stackRepository.peek();
        } catch (StackUnderflowException se) {
            Assert.assertEquals(true, (se != null));
        }
    }

    @Test
    public void testPop_success() throws StackUnderflowException, StackOverflowException {
        Integer ele = 123;
        stackRepository.push(ele);
        Integer element = stackRepository.pop();
        Assert.assertEquals(ele, element);

    }

    @Test
    public void testPop_withException() throws StackUnderflowException {
        Integer element = 0;
        try {
            element = stackRepository.pop();
        } catch (StackUnderflowException e) {
            Assert.assertEquals(true, (e != null));
        }
    }

    @Test
    public void testPush_success() throws StackOverflowException {
        Integer ele = 123;
        boolean isPushed = stackRepository.push(ele);
        Assert.assertTrue(isPushed);

    }

    @Test
    public void testPush_withException() throws StackOverflowException {
        stackRepository.push(123);
        try {
            stackRepository.push(124);
        } catch (StackOverflowException e) {
            Assert.assertEquals(true, (e != null));
        }
    }
}
