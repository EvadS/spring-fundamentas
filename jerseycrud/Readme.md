


https://www.codejava.net/java-ee/web-services/java-restful-web-services-tutorial-for-beginner-with-jersey-and-tomcat
https://www.codejava.net/java-ee/web-services/java-crud-restful-web-services-examples-with-jersey-and-tomcat
--------------------------------------------------------

//без контектста при запуске из intellij
- обратить внимание на редеплой
- томкат 9.0.72
- открівать как текущий проект

http://localhost:8080/rest/bonjour
http://localhost:8080/rest/products



. Type Command -> catalina.bat start to start the server.
4. Type Command -> catalina.bat stop to stop the server.

// http://localhost:8080/jersey-crud-example/rest/bonjour


rest
-curl http://localhost:8080/MyWebsite/rest/products/2
curl http://localhost:8080/MyWebsite/rest/products
--
curl -v -X POST -H "Content-Type: application/json"
-d "{\"name\":\"MacBook\",\"price\":1000}"
http://localhost:8080/rest/products/

---
curl -v -X PUT -H "Content-Type: application/json"
-d "{\"name\":\"iPad\",\"price\":888}"
http://localhost:8080/rest/products/1

---
curl -v -X DELETE http://localhost:8080/rest/products/2

----------------
testing
https://www.javaguides.net/2018/06/guide-to-jersey-test-framework-basics.html