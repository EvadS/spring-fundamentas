apache-tomcat 8.5.15

###Плейлист на YouTube: https://www.youtube.com/playlist?list=PL7Bt6mWpiizZq71c4wuBl7lmY-M7nen_J


если aplication context не указан
http://localhost:8080/

## Docker

### build
```
 docker build . -t local/demo-servlet
```

### run first time
```
	docker run --name demo_container  -p18080:8080 -d local/demo-servlet
```

### the second and next time
```
    docker start  demo_container
```

### open running conatainer
```
    docker exec -t -i demo_container /bin/bash
```

### check in browser
```
http://localhost:18080/sample/
```






docker run -p 80:8080 mywebapp