package com.sriharilabs;

public class MyMain {

	public static void main(String[] args) {
		 Source source = new Source();
	        source.setFoo(42);
	        source.setBar(23L);
	        source.setZip(73);

	        Target target = SourceTargetMapper.INSTANCE.sourceToTarget(source);

	        System.out.println(target.getQax());
	}

}
