class Solution {

    private int[] segmentTree = new int[400007];
    private int[] baskets;

    private void build(int p, int l, int r){
        if(l==r){
            segmentTree[p] = baskets[l];
            return;
        }

        int mid = (l+r)>>1;
        build(p<<1,l,mid);
        build(p<<1|1,mid+1,r);
        segmentTree[p] = Math.max(segmentTree[p<<1],segmentTree[(p<<1)|1]);

    }

    private int query(int p, int l, int r, int ql, int qr ){
        if(ql>r || qr<l){
            return Integer.MIN_VALUE;
        }
        if(ql<=l && r<=qr){
            return segmentTree[p];
        }
        int mid = (l+r)>>1;
        return Math.max(query(p<<1,l,mid,ql,qr), query((p<<1)|1,mid+1,r,ql,qr));
    }

    private void update(int p, int l, int r,int pos, int val ){
        if(l==r){
            segmentTree[p] = val;
            return;
        }

        int mid = (l+r)>>1;
        if(pos<=mid){
            update(p<<1,l,mid,pos,val);
        }else{
            update((p<<1)|1,mid+1,r,pos,val);
        }
        segmentTree[p] = Math.max(segmentTree[p<<1],segmentTree[(p<<1)|1]);
    }



    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        this.baskets = baskets;

        int m = baskets.length;

        int numOfUnplacedFruits =0;
        if(m==0){
            return fruits.length;
        }
        Arrays.fill(segmentTree,Integer.MIN_VALUE);
        build(1,0,m-1);

        for(int i=0;i<fruits.length;i++){
            int low=0;
            int high = m-1;
            int res =-1;

            while(low<=high){
                int mid = (low+high)>>1;
                if(query(1,0,m-1,0,mid)>=fruits[i]){
                    res = mid;
                    high= mid-1;
                }else{
                    low= mid+1;
                }
            }

            if(res!=-1 && baskets[res]>=fruits[i]){
                update(1,0,m-1,res,Integer.MIN_VALUE);
            }
            else{
                numOfUnplacedFruits++;
            }
        }

        return numOfUnplacedFruits;



    }
}