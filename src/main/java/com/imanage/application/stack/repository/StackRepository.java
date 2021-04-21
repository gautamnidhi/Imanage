package com.imanage.application.stack.repository;

import com.imanage.application.stack.exceptions.StackOverflowException;
import com.imanage.application.stack.exceptions.StackUnderflowException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Nidhi Gautam 4/18/21
 */
@Repository
public class StackRepository {

    @Value("${STACK_SIZE}")
    private int stackSize;

    public StackRepository() {
        //setting up default size
        if (stackSize == 0) {
            stackSize = 1;
        }
    }

    private AtomicInteger top = new AtomicInteger(-1);

    private List<Integer> stack = new ArrayList<>();

    public Integer peek() throws StackUnderflowException {
        if (!isEmpty()) {
            return stack.get(top.get());
        }
        throw new StackUnderflowException("Stack is Empty");
    }

    public Integer pop() throws StackUnderflowException {
        if (!isEmpty()) {
            return stack.remove(top.getAndDecrement());
        }
        throw new StackUnderflowException("Stack is Empty");
    }

    public boolean push(Integer element) throws StackOverflowException {
        if (!isFull()) {
            top.getAndIncrement();
            return stack.add(element);
        }
        throw new StackOverflowException("Stack is full");
    }

    private boolean isFull() {
        return top.get() >= stackSize - 1;
    }

    private boolean isEmpty() {
        return top.get() < 0;
    }
}
