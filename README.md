# Persona Backend

## 开发环境要求

> Jdk >1.8

> Gradle >6.6

> Mysql 

> InelliJ IDEA

## 搭建

- 建立数据库

```sql
create database persona;
```

- 在`InelliJ IDEA`打开`persona_backend`工程

- 运行`Build Project`

    等待`gradle`下载并配置环境，需要些时间

- 打开`src/main/resources/application.yml`，并修改数据库配置

```
spring:
  datasource:
    url: jdbc:mysql://localhost:13306/persona
    username: root
    password: persona
```

- 执行
```
gradle bootRun
```
    
*没有报错说明环境配置成功*
    



## How To Run

## How To Test

## How to Deploy
