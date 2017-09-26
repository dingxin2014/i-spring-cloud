package com.meituan.zhaopin.gradle

import org.gradle.api.GradleException

class FileUtil {

    static void copy(from, to) {
        File sourceFile = new File(from)
        File destFile = new File(to)

        if (!sourceFile.exists())
            throw new GradleException("source file ${from} does not exist!")
        if (!destFile.exists()) {
            def parent = destFile.getParentFile()
            if(!parent.exists())
                parent.mkdirs()

            def printWriter = destFile.newPrintWriter()

            sourceFile.writeTo(printWriter)

            printWriter.flush()
            printWriter.close()
        }
    }

}
