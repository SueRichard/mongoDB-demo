package com.hh.test;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

/**
 * @author HH
 * @version 1.0
 * @time 2024/02/07  Wed  20:51
 */
public class Demo1 {
    public static void main(String[] args) {
        //建立连接
        MongoClient mongoClient = new MongoClient("192.168.56.111", 27017);
        //得到数据源（数据库）
        MongoDatabase database = mongoClient.getDatabase("hh");
        System.out.println(database);
        //创建集合
//        database.createCollection("user-hh");
        //得到集合（表）
        MongoCollection<Document> user = database.getCollection("user");
        //集合的增删改查
        //新增
        /*Document document = new Document("_id", 101);
        document.append("name", "黄");
        document.append("age", 26);
        user.insertOne(document);
        System.out.println("新增成功");*/

        //修改单条(姓名是hh的年龄改为88)，修改多条updateMany
//        user.updateOne(Filters.eq("name", "hh"), new Document("$set", new Document("age", 88)));

        //删除
        user.deleteOne(new Document("name", "p"));


        //查询
        FindIterable<Document> documents = user.find();
        MongoCursor<Document> iterator = documents.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
