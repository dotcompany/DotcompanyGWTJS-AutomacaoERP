function vOb(){}
function ROb(){}
function QOb(){}
function TOb(){}
function XOb(){}
function WOb(){}
function JOb(a,b){a.b=b}
function KOb(a){if(a==zOb){return true}Nx();return a==COb}
function LOb(a){if(a==yOb){return true}Nx();return a==xOb}
function UOb(a){this.b=(RQb(),MQb).a;this.d=($Qb(),ZQb).a;this.a=a}
function MOb(){DOb();ZHb.call(this);this.b=(RQb(),MQb);this.c=($Qb(),ZQb);this.e[mqc]=0;this.e[nqc]=0}
function HOb(a,b){var c;c=cC(a.O,87);c.b=b.a;!!c.c&&(c.c[kqc]=b.a,undefined)}
function IOb(a,b){var c;c=cC(a.O,87);c.d=b.a;!!c.c&&mEb(c.c,lqc,b.a)}
function DOb(){DOb=imc;wOb=new ROb;zOb=new ROb;yOb=new ROb;xOb=new ROb;AOb=new ROb;BOb=new ROb;COb=new ROb}
function EOb(a,b,c){var d;if(c==wOb){if(b==a.a){return}else if(a.a){throw new yac('Only one CENTER widget may be added')}}Qe(b);o2b(a.j,b);c==wOb&&(a.a=b);d=new UOb(c);b.O=d;HOb(b,a.b);IOb(b,a.c);GOb(a);Se(b,a)}
function FOb(a,b){var c,d,e,f,g,i,j;H1b(a.Q,Cmc,b);i=new ljc;j=new z2b(a.j);while(j.a<j.b.c-1){c=y2b(j);g=cC(c.O,87).a;e=cC(i.Xc(g),131);d=!e?1:e.a;f=g==AOb?'north'+d:g==BOb?'south'+d:g==COb?'west'+d:g==xOb?'east'+d:g==zOb?'linestart'+d:g==yOb?'lineend'+d:dqc;H1b(Gl(c.Q),b,f);i.Zc(g,Qac(d+1))}}
function GOb(a){var b,c,d,e,f,g,i,j,k,n,o,p,q,r,s,t;b=a.d;while(HFb(b)>0){ol(b,GFb(b,0))}q=1;e=1;for(i=new z2b(a.j);i.a<i.b.c-1;){d=y2b(i);f=cC(d.O,87).a;f==AOb||f==BOb?++q:(f==xOb||f==COb||f==zOb||f==yOb)&&++e}r=TB(eT,{123:1,134:1},88,q,0);for(g=0;g<q;++g){r[g]=new XOb;r[g].b=$doc.createElement(iqc);kl(b,pWb(r[g].b))}k=0;n=e-1;o=0;s=q-1;c=null;for(i=new z2b(a.j);i.a<i.b.c-1;){d=y2b(i);j=cC(d.O,87);t=$doc.createElement(jqc);j.c=t;j.c[kqc]=j.b;mEb(j.c,lqc,j.d);j.c[Fmc]=Cmc;j.c[Dmc]=Cmc;if(j.a==AOb){fEb(r[o].b,t,r[o].a);kl(t,pWb(d.Q));t[Esc]=n-k+1;++o}else if(j.a==BOb){fEb(r[s].b,t,r[s].a);kl(t,pWb(d.Q));t[Esc]=n-k+1;--s}else if(j.a==wOb){c=t}else if(KOb(j.a)){p=r[o];fEb(p.b,t,p.a++);kl(t,pWb(d.Q));t[Bvc]=s-o+1;++k}else if(LOb(j.a)){p=r[o];fEb(p.b,t,p.a);kl(t,pWb(d.Q));t[Bvc]=s-o+1;--n}}if(a.a){p=r[o];fEb(p.b,c,p.a);kl(c,pWb(a.a.Q))}}
_=dhb.prototype;_.ac=function hhb(){var a,b,c;oX(this.a,(b=new MOb,b.Q[Emc]='cw-DockPanel',b.e[mqc]=4,JOb(b,(RQb(),LQb)),EOb(b,new MMb('This is the first north component'),(DOb(),AOb)),EOb(b,new MMb('This is the first south component'),BOb),EOb(b,new MMb('This is the east component'),xOb),EOb(b,new MMb('This is the west component'),COb),EOb(b,new MMb('This is the second north component'),AOb),EOb(b,new MMb('This is the second south component'),BOb),a=new MMb("This is a <code>ScrollPanel<\/code> contained at the center of a <code>DockPanel<\/code>.  By putting some fairly large contents in the middle and setting its size explicitly, it becomes a scrollable area within the page, but without requiring the use of an IFRAME.<br><br>Here's quite a bit more meaningless text that will serve primarily to make this thing scroll off the bottom of its visible area.  Otherwise, you might have to make it really, really small in order to see the nifty scroll bars!"),c=new jJb(a),c.Q.style[Fmc]=luc,c.Q.style[Dmc]=Avc,EOb(b,c,wOb),FOb(b,'cwDockPanel'),b))};_=MOb.prototype=vOb.prototype=new WHb;_.gC=function NOb(){return NN};_.tb=function OOb(a){FOb(this,a)};_.Lb=function POb(a){var b;b=DGb(this,a);if(b){a==this.a&&(this.a=null);GOb(this)}return b};_.cM={40:1,46:1,83:1,90:1,91:1,94:1,109:1,111:1};_.a=null;var wOb,xOb,yOb,zOb,AOb,BOb,COb;_=ROb.prototype=QOb.prototype=new Y;_.gC=function SOb(){return KN};_=UOb.prototype=TOb.prototype=new Y;_.gC=function VOb(){return LN};_.cM={87:1};_.a=null;_.c=null;_=XOb.prototype=WOb.prototype=new Y;_.gC=function YOb(){return MN};_.cM={88:1};_.a=0;_.b=null;var NN=hac(Wqc,'DockPanel'),MN=hac(Wqc,'DockPanel$TmpRow'),eT=gac(Erc,'DockPanel$TmpRow;',MN),KN=hac(Wqc,'DockPanel$DockLayoutConstant'),LN=hac(Wqc,'DockPanel$LayoutData');Amc(tj)(29);