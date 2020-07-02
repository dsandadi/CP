public class A {
        public boolean isPathCrossing(String path) {
            int countx = 0, county = 0;
            for(int i = 0; i < path.length(); i++){
                if(path.charAt(i) == 'N'){
                    county++;
                }
                if(path.charAt(i) == 'S'){
                    county--;
                }
                if(path.charAt(i) == 'E'){
                    countx++;
                }
                if(path.charAt(i) == 'W'){
                    countx--;
                }
                if(countx == 0 && county == 0)
                    return true;
            }
            return false;
        }
        public static void main(String[] args){
            String[] ar = {"NES","NESWW"};
            A a = new A();
            for(String str: ar)
                System.out.println(a.isPathCrossing(str));
        }
}
