package com.jdb.demo.elasticsearch.repository;

import com.jdb.demo.elasticsearch.domain.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticeRepository extends ElasticsearchRepository<Article,Long> {

}
