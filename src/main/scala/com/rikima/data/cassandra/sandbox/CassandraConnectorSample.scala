package com.rikima.data.cassandra.sandbox

import com.datastax.driver.core.{Row, ResultSet, Cluster}

/**
  * Created by mrikitoku on 2016/01/07.
  */
object CassandraConnectorSample {

  def main(args: Array[String]): Unit = {
    val host = "127.0.0.1"
    val keyspace = "r2a"
    val table = "pck_query"

    // Connect to the cluster and keyspace "demo"
    val cluster = Cluster.builder().addContactPoint(host).build()
    val session = cluster.connect(keyspace)
    // Use select to get the user we just entered
    val  results = session.execute(s"SELECT * FROM $table")
    val iter = results.iterator()
    while (iter.hasNext) {
      val row = iter.next()
      println(row.toString)
    }
  }
}
