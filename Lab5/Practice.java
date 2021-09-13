package Lab5;
public int countHeads(){
    int count = 0;
    for(Boolean x:coins){
        if(x == HEADS){
            count++;
        }
    }
    return count;
}

public String toString(){
    String s = "";
    for(int i = 0; i<coins.length();i++){
        if(coins[i] == HEADS){
            s += 'H';
        }else if( coins[i] == TAILS){
            s += 'T';
        }
    }
    return s;
}

public Coins(String c){
    coins = new Boolean(c.length());
    for(int i = 0;i<coins.length;i++){
        if(c.charAt(i) == 'H'){
            coins[i] += HEADS;
        }else if(c.charAt(i) == 'T'){
            coins[i] += TAILS;
        }
    }
}

public Coins(int length){
    coins = new Boolean(length);
    Random rand = new Random();
    for(int i = 0; i<coins.length;i++){
        int r = rand.nextInt(2);
        if(r ==0){
            coins[i] += HEADS;
        }else{
            coins[i] += TAILS;
        }
    }
}

public int countRuns(){
    int count = 0;
    for(int i = 0;i<coins.length -1;i++){
        if(coins[i] != coins[i+1]){
            count++;
        }
    }
}

public static long digits(long n){
    if(n/10){
        return 1;
    }else{
        return 1 + digits(n/10);
    }
}

public static long sumOfDigits(long n){
    if(n == 0){
        return n;
    }else{
        return n%10 + sumOfDigits(n/10);
    }
}


public int height(){
    if(isEmpty()){
        return 0;
    }else{
        return 1 + rest.height();
    }
}

public int count(char c){
    if(isEmpty()){
        return n;
    }else if(c == top){
        return 1+ rest.count(c);
    }else{
        return 0 + rest.count(c);
    }
}

public int countHeads(){
    int count = 0;
    for(Boolean x:coins){
        if(x == HEADS){
            count++;
        }
    }
    return count;
}

public String toString(){
    String s = "";
    for(int i = 0; i<coins.lrngth();i++){
        if(coins[i] == HEADS){
            s += 'H';
        }else if(coins[i] == TAILS){
            s += 'T'';
        }
    }

    return s;
}

public Coins(String c){
    coins = new boolean(c.length());
    for(int i = 0;i<coins.length;i++){
        if(c.charAt(i) == 'H'){
            coins[i] += HEADS;
        }else if(c.charAt(i) == 'T'){
            coins[i] += TAILS;
        }
    }
}

public Coins(int length){
    coins = new Boolean(length);
    Random rand = new Random();
    for(int i = 0;i<coins.length;i++){
        int r = rand.nextInt(2);
        if(r == 0){
            coins[i] += HEADS;
     
        }else{
            coins[i] +=TAILS;
        }
    }
}

public int countHeads(){
    int count = 0;
    for(int i = 0;i<coins.length-1;i++){
        if(coins[i] != coins[i+1]){
            count++;
        }
    }
    return count;
}

public static long digits(long n){
    if(n/10){
        return 1;
    }else{
        return 1 + digits(n/10);
    }
}

public static long sumOfDigits(long n){
    if(n==0){
        return n;
    }else{
        return n%10 + sumOfDigits(n/10);
    }
}

public int height(){
    if(isEmpty()){
        return 0;
    }else{
        return rest.height();
    }
}

public int count(char c){
    if(isEmpty()){
        return 0;
    }else if(top == c){
        return 0 + rest.count(c);
    }else{
        return 1 + rest.count(c);
    }
}
