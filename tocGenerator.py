with open('Content.md', 'r') as inf, open('ToC.txt', 'w') as outf:
    for line in inf:

        if(line[:3] == "## " and line[3:].rstrip() != "Table of contents"):
            title = line[3:].rstrip()
            l = "- [" + title + "](#" + title.replace(' ', '-').lower() + ")\n" 
            outf.write(l)

        elif(line[:3] == "###"):
            title = line[4:].rstrip()
            l = "\t * [" + title + "](#" + title.replace(' ', '-').lower() + ")\n"
            outf.write(l)

    outf.close()