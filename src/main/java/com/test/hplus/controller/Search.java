package com.test.hplus.controller;


import com.test.hplus.bean.Product;
import com.test.hplus.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.async.DeferredResult;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@Controller
public class Search {

    @Autowired
    ProductRepository productRipository;

    @Autowired
    private AsyncTaskExecutor taskExecutor;



/*    public Callable<String> search(@RequestParam("search") String search, Model model, HttpServletRequest request)
    {
        System.out.println("in search controller");
        System.out.println("search criteria:" +search );
        System.out.println("AsyncSupport in App: "+request.isAsyncSupported());
        System.out.println("Thread from servlet contaner: " + Thread.currentThread().getName());

        return ()->
       {
           Thread.sleep(3000);
           System.out.println("Thread from spring mvc: " + Thread.currentThread().getName());
           List<Product> products = new ArrayList<>();
           products=productRipository.searchByName(search);
           model.addAttribute("products",products);
           return "search";
       };
    }*/
   @GetMapping("/search")
    public DeferredResult<String> search(@RequestParam("search") String search, Model model, HttpServletRequest request)
    {
        DeferredResult<String> deferredResult = new DeferredResult<>();
        System.out.println("in search controller");
        System.out.println("search criteria:" +search );
        System.out.println("AsyncSupport in App: "+request.isAsyncSupported());
        System.out.println("Thread from servlet contaner: " + Thread.currentThread().getName());
        taskExecutor.execute(()->{
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread from the spring mvc task executor: "+Thread.currentThread().getName());
            List<Product> products = new ArrayList<>();
            products = productRipository.searchByName(search);
            model.addAttribute("products", products);
            deferredResult.setResult("search");
        });
        return deferredResult;

    }
}
