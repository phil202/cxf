/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.cxf.jaxrs.model.wadl;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import org.apache.cxf.jaxrs.ext.Description;
import org.apache.cxf.jaxrs.fortest.jaxb.packageinfo.Book2;
import org.apache.cxf.jaxrs.model.wadl.jaxb.Book;
import org.apache.cxf.jaxrs.model.wadl.jaxb.Chapter;

@Path("/bookstore/{id}")
@Consumes({"application/xml", "application/json" })
@Produces({"application/xml", "application/json" })
@Description(lang = "en-us", title = "book store resource", value = "super resource")
public class BookStore {

    @GET 
    @Produces("text/plain")
    public String getName(@PathParam("id") Long id, @QueryParam("") QueryBean query) {
        return "store";
    }
    
    @POST
    @Path("books/{bookid}")
    //CHECKSTYLE:OFF
    public Book addBook(@PathParam("id") int id,
                        @PathParam("bookid") int bookId,
                        @MatrixParam("mid") int matrixId,
                        @HeaderParam("hid") int headerId,
                        @CookieParam("cid") int cookieId,
                        @QueryParam("provider.bar") int queryParam,
                        @Context HttpHeaders headers,
                        Book b) {
        return new Book(1);
    }
    //CHECKSTYLE:ON
    @Path("booksubresource")
    public Book getBook() {
        return new Book(1);
    }
    
    @GET
    @Path("chapter")
    public Chapter getChaper() {
        return new Chapter(1);
    }
    
    @Path("itself")
    public BookStore getItself() {
        return this;
    }
    
    @Path("book2")
    @GET
    public Book2 getBook2() {
        return new Book2();
    }
    
    public static class QueryBean {
        private int a;
        private int b;
        private QueryBean2 bean;
        
        public int getA() {
            return a;
        }
        
        public int getB() {
            return b;
        }
        
        public QueryBean2 getC() {
            return bean;
        }
        
        public void setC(QueryBean2 c) {
            bean = c;
        }
    }
    
    public static class QueryBean2 {
        private int a;
        private int b;
        private QueryBean3 bean;
        
        public int getA() {
            return a;
        }
        
        public int getB() {
            return b;
        }
        
        public QueryBean3 getD() {
            return bean;
        }
        
        public void setD(QueryBean3 d) {
            bean = d;
        }
    }
    
    public static class QueryBean3 {
        private int a;
        private int b;
        
        public int getA() {
            return a;
        }
        
        public int getB() {
            return b;
        }
    }
}
