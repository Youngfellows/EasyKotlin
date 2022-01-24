package com.easykotlin.learn.study10;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ShellUtilDemo {

    @Test
    public void testExecuteShellCmd() {
        String result = ShellUtil.execute("adb devices");
        System.out.println(result);
    }

    @Test
    public void testExecuteShellCmd2() {
        String[] cmds = {".", "-c", "ls -al .. | grep .kt$"};
        String result = ShellUtil.execute(cmds);
        System.out.println(result);
    }
}
