package com.rackspace.cloud.api.wadl

import scala.xml._
import javax.xml.transform._
import javax.xml.transform.stream._
import java.io.ByteArrayInputStream

//
//  Converters
//
object Converters {
  //
  //  Convert a node sequence to a ByteArrayInputStream
  //
  implicit def nodeSeq2ByteArrayInputStream(ns : NodeSeq) : ByteArrayInputStream = new ByteArrayInputStream(ns.toString().getBytes())


  //
  //  Convert a node sequence string touple to a ByteArrayInputStream with a system ID set
  //
  implicit def nodeSeqString2Source (nss : (String, NodeSeq)) : (String, ByteArrayInputStream) = {
    val s = nodeSeq2ByteArrayInputStream(nss._2)
    (nss._1, s)
  }

  //
  //  Convert a byte array stream result to a NodeSeq
  //
  implicit def byteArrayStreamResult2NodeSeq(sr : StreamResult) : NodeSeq = XML.loadString (sr.getOutputStream().toString())
}
