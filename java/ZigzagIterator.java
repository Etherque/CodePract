//Given two 1d vectors, implement an iterator to return their elements alternately.

public class ZigzagIterator {
   private List<Iterator<Integer>> iterlist;
   public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
      iterlist = new ArrayList<> ();
      if(!v1.isEmpty()) {
          iterlist.add(v1.iterator());
      }
      if(!v2.isEmpty()) {
          iterlist.add(v2.iterator());
      }
   }
   
   public int next() {
      if(!hasNext()) {
        return -1;
      }
      Iterator<Integer> tmp = iterlist.remove(0);
      int val = tmp.next();
      
      if(tmp.hasNext()) {
        iterlist.add(tmp);
      }
      return val;
   }
   
   public boolean hasNext() {
      return !iterlist.isEmpty();
   }
}