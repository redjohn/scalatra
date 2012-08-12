package org.scalatra
package liftjson

import net.liftweb.json._
import scala.io.Codec.UTF8
import net.liftweb.json.Xml.toXml
import xml.{NodeSeq, XML}
import xml.Utility.trimProper
import io.Codec
import json.JsonOutput
import java.io.PrintWriter

@deprecated("Use LiftJsonSupport instead", "2.1.0")
trait JsonSupport extends LiftJsonOutput

private[liftjson] trait LiftJsonOutput extends JsonOutput {


  protected type JsonType = JValue

  protected def jsonClass: Class[_] = classOf[JsonType]

  protected def writeJsonAsXml(json: JsonType): NodeSeq = toXml(json)

  protected def writeJson(json: JsonType, writer: PrintWriter) { Printer.compact(render(json), writer) }

}
