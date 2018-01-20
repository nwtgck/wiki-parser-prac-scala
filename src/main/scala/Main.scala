import java.io.File

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD
import _root_.io.mindfulmachines.wiki_parser.wiki


object Main{
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setAppName( "SparkTest" )
      .setMaster("local[*]" )
      .set("spark.executor.memory", "1g")
    val sc    = new SparkContext( conf )

    val rawPages: RDD[(Long, String)] =
      // ("wikidump.xml" from: https://raw.githubusercontent.com/nwtgck/wiki-parser-scala/master/src/test/resources/wikidump.xml)
      wiki.Parser.readWikiDump(sc, "wikidump.xml")

    val pages   : RDD[(Long, wiki.Parser.Page)] =
      wiki.Parser.parsePages(rawPages)

    println(pages.count)
  }
}