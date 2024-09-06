/*!
 * 
 *     MCAFEE RESTRICTED CONFIDENTIAL
 *     Copyright (c) 2024 McAfee, LLC
 *
 *     The source code contained or described herein and all documents related
 *     to the source code ("Material") are owned by McAfee or its
 *     suppliers or licensors. Title to the Material remains with McAfee
 *     or its suppliers and licensors. The Material contains trade
 *     secrets and proprietary and confidential information of McAfee or its
 *     suppliers and licensors. The Material is protected by worldwide copyright
 *     and trade secret laws and treaty provisions. No part of the Material may
 *     be used, copied, reproduced, modified, published, uploaded, posted,
 *     transmitted, distributed, or disclosed in any way without McAfee's prior
 *     express written permission.
 *
 *     No license under any patent, copyright, trade secret or other intellectual
 *     property right is granted to or conferred upon you by disclosure or
 *     delivery of the Materials, either expressly, by implication, inducement,
 *     estoppel or otherwise. Any license under such intellectual property rights
 *     must be expressed and approved by McAfee in writing.
 *
 */(()=>{"use strict";const e=0,t="PRINT_IN_BACKGROUND",o={NONE:0,INFO:1,ERROR:2,WARN:3,DEBUG:4,ALL_IN_BACKGROUND:99},s=1,n=2,i=3,c=4,r={BACKGROUND:"BACKGROUND",CONTENT:"CONTENT",TELEMETRY:"TELEMETRY"},l={DEFAULT:"color: #000000; font-weight: normal; font-style:normal; background: #FFFFFF;",BACKGROUND:"color: #8D0DBA; font-weight: bold; background: #FFFFFF;",CONTENT:"color: #F54A26; font-weight: bold; background: #FFFFFF;",TELEMETRY:"color: #147831; font-weight: bold; background: #FFFFFF;"};const a=new class{constructor(){this.storageChecked=!1,this.logLevel=null,this.queue=[];const t="MCLOGLEVEL";chrome?.storage?.local.get([t]).then((s=>{const n=Object.values(o).includes(s[t]);this.logLevel=n?s[t]:e,this.logLevel!==o.NONE&&this.queue.forEach((({callback:e,message:t,processType:o})=>{e(t,o)})),this.queue=[],this.storageChecked=!0}))}log(e,t=null){this.storageChecked?this.processLog(e,s,t,this.logLevel):this.queue.push({callback:this.log.bind(this),message:e,processType:t})}error(e,t=null){this.storageChecked?this.processLog(e,n,t,this.logLevel):this.queue.push({callback:this.error.bind(this),message:e,processType:t})}warn(e,t=null){this.storageChecked?this.processLog(e,i,t,this.logLevel):this.queue.push({callback:this.warn.bind(this),message:e,processType:t})}debug(e,t=null){this.storageChecked?this.processLog(e,c,t,this.logLevel):this.queue.push({callback:this.debug.bind(this),message:e,processType:t})}processLog(e,s,i,c){if(c===o.NONE)return;let l="chrome-extension:"===location.protocol?r.BACKGROUND:r.CONTENT;i&&r[i]&&(l=i);const a=new Date,d=s===n?e:`%c[${l} ${a.toLocaleString([],{hour:"2-digit",minute:"2-digit",second:"2-digit",hour12:!0})}]: %c${e}`;l===r.CONTENT&&this.logLevel===o.ALL_IN_BACKGROUND&&chrome.runtime.sendMessage({command:t,logMessage:d,processType:l,logType:s,logLevel:c}),this.printLog(d,l,s,c)}printLog(e,t,r,a){const d=l.DEFAULT,h=l[t]||d;if(a>=o.ERROR&&r===n&&console.error(e),a>=o.INFO&&r===s&&console.log(e,h,d),a>=o.WARN&&r===i){const t="color: #FFA500; font-family: sans-serif; font-weight: bolder; text-shadow: #000 1px 1px;";console.log(`%cWARN - ${e}`,t,h,d)}if(a>=o.DEBUG&&r===c){const t="color: #FF33D7; font-family: sans-serif; font-weight: bolder; text-shadow: #000 1px 1px;";console.log(`%cDEBUG - ${e}`,t,h,d)}}};class d{constructor(e,t){this.pingCommand=e,this.ipcId=t,this.mainFunction="function"==typeof this.main?((e,t)=>{let o;return(...s)=>(e&&(o=e.apply(t||void 0,s),e=null,t=null),o)})(this.main,this):()=>{},this.basePingListener(),this.addIdentifier()}basePingListener(){((e,t=null,o)=>{"function"==typeof o?chrome.runtime.onMessage.addListener(((s,n,i)=>{if(n.id===chrome.runtime.id&&"object"==typeof s&&!Array.isArray(s)&&s?.ipcId===e)return o({promises:t,request:s,sender:n,sendResponse:i})})):a.error("Provided with invalid callback function")})(this.ipcId,null,(({request:e,sendResponse:t})=>{const{command:o,...s}=e;if(o===this.pingCommand)return a.debug(`File Injection [pinged]: Received ${o} command`),t({content:!0}),"function"==typeof this.mainFunction&&this.mainFunction(s),"function"==typeof this.callback&&this.callback(),!0}))}addIdentifier(){var e;e=()=>{const e=document.createElement("span");e.id=this.pingCommand,e.style.cssText="display:none",document.body.appendChild(e)},"undefined"!=typeof document&&null!==document&&("complete"===document.readyState||"loading"!==document.readyState&&!document.documentElement.doScroll?e():document.addEventListener("DOMContentLoaded",e))}}const h="PING_CONTENT_MB_INJECT_SCRIPT",u="MB",g={MB_CONTENT_PAGE_INJECT:"MockingBird-Package/scripts/mockingbird_content_page_inject.js",MB_CONTENT_MAIN:"MockingBird-Package/scripts/mockingbird_content_main.js"};(new class extends d{constructor(){super(h,u)}init(){const e=document.createElement("script");e.src=chrome.runtime.getURL(g.MB_SCRIPT_ATTACH_SHADOW),(document.head||document.documentElement).appendChild(e),a.log("[MB:MockingBirdContentPageInject] patching shadow.")}}).init()})();
//# sourceMappingURL=../../sourceMap/chrome/MockingBird-Package/scripts/mockingbird_content_page_inject.js.map