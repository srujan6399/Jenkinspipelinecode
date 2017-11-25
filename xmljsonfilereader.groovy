@NonCPS
def getFileExt(def json) {
  def extension = ''
  def matcher = (json =~ /[^\.]*$/)
  if (matcher.size() > 0) {
    println matcher[0]
    extension = matcher[0]
  }
  return  extension;
}
@NonCPS
def getXML(def xmldata) {
    return new XmlParser().parseText(xmldata)
}
node{
    stage("extn"){
    //String filePath = "C:/Users/manth/Desktop/opencover.xml"
    String filePath = "C:/Users/manth/Desktop/sample.json"
    string ex = getFileExt(filePath);
        if(ex.equalsIgnoreCase("json")){
            def json = readJSON file: filePath
            println(json.author.name)
        }
        else{
            def xml = getXML(readFile(filePath))
            //groovy.util.Node xml = getXML(filePath)
            //def xml = new XmlParser().parseText(readFile(filePath))
            println xml.Modules.Module[0].ModuleName.text()
        }     
    }  
}

