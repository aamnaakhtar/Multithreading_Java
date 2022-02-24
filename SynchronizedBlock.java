import java.util.ArrayList;
import java.util.List;

////Synchronized Block


class BlockClass{
	String name = "";
	public int count = 0;

	public void blockName(String str, List<String> list){
		synchronized(this){
			name = str;
			count++; 
			}
		list.add(str);
	}
}

class SynchronizedBlock{
	public static void main (String[] args){
		BlockClass obj = new BlockClass();
		List<String> list = new ArrayList<String>();
		obj.blockName("aamna", list);
		System.out.println(obj.name);
	}
}

