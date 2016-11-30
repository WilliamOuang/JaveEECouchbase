package com.couchbase.coursesystem;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.EntityDocument;
import com.couchbase.client.java.query.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 * Created by William Ouyang on 11/29/2016.
 */
@Named("CourseSystemRepo")
@ApplicationScoped
public class CourseSystemRepository {

    CouchbaseCluster cluster;
    Bucket bucket;



    @PostConstruct
    public void buildClient() {
        cluster = CouchbaseCluster.create();
        bucket = cluster.openBucket("travel-sample");

    }


    @PreDestroy
    public void stop() {
        cluster.disconnect();
    }



}
