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
- what's Spark RDD?
- the purpose of your project
![RDD Zeppelin Notebook](./.assets/rdd_zeppelin_notebook.png)

## Spark DataFrame Project
- what's Spark Structured API?
	- SQL, DF, Dataset
  - Why structured API is preferred over RDDs?
- the purpose of your project
![DataFrame Zeppelin Notebook](./.assets/dataframe_zeppelin_notebook.png)