# Spark/Scala Project
## Introduction
The purpose of this project was to evaluate Apache Spark as a big data evaluation tool. The main focus of this evaluation
was to compare Spark RDD and Structured API (In this case, DataFrames) data structures, in order to determine their
effectiveness at manipulating data. All comparisons were made through queries on the WID dataset, performed on a Hadoop
cluster hosted through Google Cloud Computing, utilzing Zeppelin to record all results. Through this investigation, it
was found that while it is possible to get the same functionality out of both RDDs and DataFrames, DataFrames are the
preferred structure to use, as they are much higher level than RDDs, and much easier to use. RDDs should only be used
in situations where the low-level access they provide is necessary.

## Spark Architecture
![Spark Cluster Diagram](./.assets/spark_cluster_diagram.png)

## Spark RDD Project

RDD stands for Resilient Distributed Dataset. It is a low-level Spark data structure which is fault-tolerant (resilient)
and resides on multiple nodes withing the cluster (disributed), and is made of a collection of partitioned data,
consisting of primitive values, and container values (such as tuples). They support two kinds of operation:
Transformations, which are lazily evaluated, meaning that they are not actually applied until a result is actually
needed, and Actions, which are not lazy, trigger computations from transformations and returning a value.

The purpose of the RDD project was to become familiar with RDDs, how to create them, and how to use them to query big
datasets. 

![RDD Zeppelin Notebook](./.assets/rdd_zeppelin_notebook.png)

## Spark DataFrame Project

The Spark Structured API is a combination of three main distributed collection APIs: Datasets, DataFrames, and SQL tables.
SQL works the same as SQL used on other systems. Datasets and DataFrames are quite similar, in that they are both
ditributed table-like structures, however DataFrames are "untyped", meaning types are checked at runtime, while Datasets
are "typed", meaning their types are checked at compile time. DataFrames are the preferred way of using Spark, as unlike
SQL, they can combine transformations lazily in order to be more efficient, and they have better internal optimization
when compared to Datasets.

DataFrames are the preferred method for using Spark over RDDs as well. DataFrames are newer, and thus faster and more
space efficient than the older RDDs. However, DataFrames are a very high level implementation, so it is possible that
if lower level calculations are needed, you may have to use RDDs.

The purpose of the DataFrame project was to learn how to use Spark Structured APIs to perform computations on large
datasets. Specifically, DataFrames were the main focus, with SQL being used to confirm the validity of the queries.

![DataFrame Zeppelin Notebook](./.assets/dataframe_zeppelin_notebook.png)