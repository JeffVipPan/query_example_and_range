# query_example_and_range
#Spring Data JPA为我们提供了Query With Example来实现动态条件查询，
#当查询条件为空的时候，我们不用做大量的条件判断。但是Query With Example却不支持范围查询(包括日期范围，数值范围查询)，
#通过Specification实现了既支持动态条件查询又支持范围查询的方法。
