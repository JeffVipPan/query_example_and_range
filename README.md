# query_example_and_range

- Spring Data JPA为我们提供了Query With Example来实现动态条件查询，
- 当查询条件为空的时候，我们不用做大量的条件判断。但是Query With Example却不支持范围查询(包括日期范围，数值范围查询)，
- 通过Specification实现了既支持动态条件查询又支持范围查询的方法。


- 1:将Date类型改为 Java 8 LocalDate 类型
- 2:审计字段测试成功 @CreatedBy ...

-修改审计字段为父类，这样就不需要每个字段都加这个字段
- 父类需要加@MappedSuperclass

- 通过jackson-datatype-jsr310解决LocalDate是数组问题
- 返回值为    "localDate": "2010-10-12"

