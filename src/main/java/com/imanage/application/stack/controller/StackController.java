package com.imanage.application.stack.controller;

import com.imanage.application.stack.exceptions.StackOverflowException;
import com.imanage.application.stack.exceptions.StackUnderflowException;
import com.imanage.application.stack.service.StackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * @author Nidhi Gautam 4/18/21
 */
@RestController
@RequestMapping("/stack")
public class StackController {

    private final StackService stackService;

    @Autowired
    public StackController(StackService stackService) {
        this.stackService = stackService;
    }

    @GetMapping("/peek")
    public Integer get() throws StackUnderflowException {
        return stackService.peek();
    }

    @DeleteMapping("/pop")
    public Integer pop() throws StackUnderflowException {
        return stackService.pop();
    }

    @PostMapping("/push/{element}")
    public boolean push(@PathVariable Integer element) throws StackOverflowException {
        return stackService.push(element);
    }
}
