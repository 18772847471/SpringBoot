package com.example.jstack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Test {

    HashMap<String,Object> map = new HashMap<String,Object>();

    List<String> list2 = Collections.synchronizedList(new ArrayList<String>());
}
