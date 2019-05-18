node{
    stage('HTML'){
        echo 'HTML'
        def file = readFile "E:/sample.html"
        //println(file)
        def split = file.split("\n")
        println(split)
        split.each{ fline -> 
            //println("HTML>>>>>>>>>>>"+fline)
            if(fline.contains('title="Follow @sw12"')){
                def splitline = fline.split(" ")
                //println(">>>>>>>>>"+splitline[1])
                splitline.each{ fline1 ->
                    //println(">>>>>>>>>>>."+fline1)
                    if(fline1.contains("Fol")){
                        println(fline1)
                    }
                }
                
            }
        }
    }
}