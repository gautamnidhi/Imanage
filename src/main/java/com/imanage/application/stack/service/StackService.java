package com.imanage.application.stack.service;

import com.imanage.application.stack.exceptions.StackOverflowException;
import com.imanage.application.stack.exceptions.StackUnderflowException;
import com.imanage.application.stack.repository.StackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Nidhi Gautam 4/18/21
 */
@Service
public class StackService {
    private final StackRepository stackRepository;

    @Autowired
    public StackService(StackRepository stackRepository) {
        this.stackRepository = stackRepository;
    }

    public Integer peek() throws StackUnderflowException {
        return stackRepository.peek();
    }

    public Integer pop() throws StackUnderflowException {
        return stackRepository.pop();

    }

    public boolean push(Integer element) throws StackOverflowException {
        return stackRepository.push(element);
    }

}
