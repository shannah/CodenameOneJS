/**
 * 
 *         
 *         <p>The Codename One JS Bridge package includes classes that facilitate the
 *             interaction between Java and Javascript in a Codename One application.
 *             It allows both Java to Javascript communication and the reverse via a
 *             mechanism similar to the one employed by Phone Gap/Apache Cordova.</p>
 *         
 *         <h2>Requirements</h2>
 *         
 *         <p>Currently the CodenameOne bridge will only run on platforms that include a native browser component.   This includes only
 *             iOS and Android currently.  Blackberry will be supported soon, but its native browser component is still quite buggy
 *             and is disabled by default.</p>
 *         
 *         <h2>Installation</h2>
 *         
 *         <p>To use the Codename One JS Bridge, you simply need to include the <code>ca.weblite.codename1.js</code> package in your
 *             project.  The easiest way to do that currently is to check it out from SVN and copy the directory into the src directory
 *             of your project.</p>
 *         
 *         <p>E.g. Step 1:  Check out from SVN:</p>
 *         <code><pre>$ svn co svn checkout http://codenameone-incubator.googlecode.com/svn/trunk/shannah/CodenameOneTests/src/ca/weblite/codename1/js js</pre></code>
 *         
 *         <p>This will check out the js package into your current working directory.  Next, create the necessary directory structure in your
 *             project's src directory:</p>
 *         
 *         <code><pre>
 * $ cd /path/to/myproject/src
 * $ mkdir ca ca/weblite ca/weblite/codename1
 *             </pre></code>
 *         
 *         <p>Finally, copy the <code>js</code> directory that you checked out of SVN into your source directory:</p>
 *         
 *         <code><pre>
 * $ cp -r /path/to/js /path/to/myproject/src/ca/weblite/codename1/
 *             </pre></code>
 *         
 *         
 *         <h2>Usage</h2>
 *         
 *         <p>The {@ref JavascriptContext} class lays the foundation by enabling you to call
 *             Javascript code directly from Java.  It provides automatic type conversion
 *             between Java and Javascript types as follows:</p>
 *         
 *         <h3>Java to Javascript</h3>
 *         <table border="1">
 *             <thead><tr><th>Java Type</th><th>Javascript Type</thead>
 *             <tbody>
 *                 <tr>
 *                     <td>String</td><td>String</td>
 *                 </tr>
 *                 <tr>
 *                     <td>Double/Integer/Float/Long</td><td>Number</td>
 *                 </tr>
 *                 <tr>
 *                     <td>Boolean</td><td>Boolean</td>
 *                 </tr>
 *                 <tr>
 *                     <td>JSObject</td><td>Object</td>
 *                 </tr>
 *                 <tr>
 *                     <td>null</td><td>null</td>
 *                 </tr>
 *                 <tr>
 *                     <td>Other</td><td>Not Allowed</td>
 *                 </tr>
 *             </tbody>
 *         </table>
 *          
 *         <h3>Javascript to Java</h3>
 *         
 *         <table border="1">
 *             <thead>
 *                 <tr>
 *                     <th>Javascript Type</th><th>Java Type</th>
 *                 </tr>
 *             </thead>
 *             <tbody>
 *                 <tr>
 *                     <td>Number</td><td>Double</td>
 *                 </tr>
 *                 <tr>
 *                     <td>String</td><td>String</td>
 *                 </tr>
 *                 <tr>
 *                     <td>Boolean</td><td>Boolean</td>
 *                 </tr>
 *                 <tr>
 *                     <td>Object</td><td>JSObject</td>
 *                 </tr>
 *                 <tr>
 *                     <td>Function</td><td>JSObject</td>
 *                 </tr>
 *                 <tr>
 *                     <td>Array</td><td>JSObject</td>
 *                 </tr>
 *                 <tr>
 *                     <td>null</td><td>null</td>
 *                 </tr>
 *                 <tr>
 *                     <td>undefined</td><td>null</td>
 *                 </tr>
 *             </tbody>
 *         </table>
 *         
 *         <p>
 *             Note that this conversion table is more verbose than necessary, since Javascript functions 
 *             and arrays are, in fact Objects themselves, so those rows are redundant.  All Javascript
 *             objects are converted to {@link ca.weblite.codename1.js.JSObject}s.
 *         </p>
 *         
 *         <h3>Getting Started</h3>
 *         
 *         <p>In order to start interacting with a Javascript environment, you need to create
 *             a WebBrowser and load a page.  Then inside the WebBrowser's onLoad() handler, you
 *             can create a JavascriptContext on the internal BrowserComponent object:</p>
 *         
 *         <script src="https://gist.github.com/4512578.js"></script>
 *         
 *         <h3>Getting Values</h3>
 *         
 *         <p>The {@link ca.weblite.codename1.js.JavascriptContext#get(String)} method is used to get values from Javascript.  
 *             It takes an arbitrary Javascript expression, executes it, and returns the
 *             result, after converting it to the corresponding Java type.  E.g. if the result
 *             is a String, it will return a String and if it is a Number it will return a 
 *             java Double object.  If the result is an Object, it will return a {@link ca.weblite.codename1.js.JSObject}.</p>
 *         
 *         <p>The following is a simple example that retrieves the document content, which
 *             is a string:</p>
 *         
 *         <script src="https://gist.github.com/4512690.js"></script>
 *         
 *         <p>If you run this example in the simulator, you'll see something like the following:</p>
 *         
 *         <p>
 *             <center>
 *                  <img src="http://media.weblite.ca/files/photos/hello-world-cn1.png"/>
 *             </center>
 *         </p>
 *         
 *         <p>Note:  You don't see the WebBrowser in the background here due to a bug in the simulator.
 *             If you run this example on a device, you will see the WebBrowser component in the background.</p>
 *         
 *         <h4>Returning Numeric Values</h4>
 *         
 *         <p>As mentioned in the conversion table above, numeric values are automatically
 *             converted to java.lang.Double objects.  The following example, returns the width and height
 *             properties of the window for use in Java.</p>
 *         
 *         <script src="https://gist.github.com/4512756.js"></script>
 *         
 *         <p>The result, when run in the simulator would be something like:</p>
 *         
 *         <p>
 *             <center><img src="http://media.weblite.ca/files/photos/window-size.png"/></center>
 *         </p>
 * 
 * 
 *         <h4>Returning Objects</h4>
 *         
 *         <p>The previous examples involved only primitive return values.  The {@link ca.weblite.codename1.js.JavascriptContext} abstraction,
 *             in these cases, doesn't offer a whole lot of added-value over just using the BrowserComponent.executeJavascriptAndReturnString()
 *             method.  The real value is when we are dealing with objects.</p>
 *         <p>The following example obtains a reference to the <code>window</code> object and wraps it in a 
 *             proxy {@link ca.weblite.codename1.js.JSObject} class so that we can work directly with the window object:</p>
 *         
 *         <script src="https://gist.github.com/4512795.js"></script>
 *         
 *         <p>This code produces the exact same result as the previous example.  The difference
 *             is the intermediary step of wrapping the window object in a {@link ca.weblite.codename1.js.JSObject}, and
 *             obtaining the outerHeight and outerWidth properties directly via that proxy object.</p>
 *         
 *         <p>You can obtain a {@link ca.weblite.codename1.js.JSObject} proxy for any Javascript object, even ones that you create
 *             on the fly.  The following example creates an anonymous object with some keys and values
 *             and uses a {@link ca.weblite.codename1.js.JSObject} proxy to interact with this object from Java.</p>
 *         
 *         <script src="https://gist.github.com/4512841.js"></script>
 *         
 *         <p>The result is as follows:</p>
 *         
 *         <p><center><img src="http://media.weblite.ca/files/photos/steve-is-34-dialog.png"/></center></p>
 * 
 *         <p>See <a href="#working-with-objects">Working With Objects</a> for more information
 *             about working with the {@link ca.weblite.codename1.js.JSObject} class.</p>
 *         
 *         <h4>Returning Functions and Arrays</h4>
 *         
 *         <p>In Javascript, functions and arrays are just objects, so these are also encapsulated as {@link ca.weblite.codename1.js.JSObject}
 *             proxies.  See <a href="#working-with-arrays">Working with Arrays</a> and 
 *             <a href="#working-with-functions">Workin with Functions</a> for more details on how to work
 *             with these values via the {@link ca.weblite.codename1.js.JSObject} interface.</p>
 *         
 *         <h3>Setting Values</h3>
 *         
 *         <p>Just as you can get values from Javascript using {@link ca.weblite.codename1.js.JavascriptContext}'s get() method, you can
 *             also set values via {@link ca.weblite.codename1.js.JavascriptContext#set(String,Object)}.</p>
 *         
 *         <p>The following is a simple example that sets the location, and causes it to redirect to
 *             a different page:</p>
 *         
 *         <script src="https://gist.github.com/4512960.js"></script>
 *         
 *         
 *         <p>If you run this example, you should see your browser display the Codename One website after
 *             a redirect.</p>
 *         <p><center><img src="http://media.weblite.ca/files/photos/redirect-to-codename1.png"/></center></p>
 * 
 * 
 *         <h4>Setting Object Values</h4>
 *         
 *         <p>The previous example showed us setting a primitive String value.  You can do the same with other
 *             primitives like numbers and booleans, but you can also set Object values using the set() method.
 *         </p>
 *         
 *         <p>The following example creates an anonymous Javascript object, wraps it in a {@link ca.weblite.codename1.js.JSObject} proxy,
 *             sets some values on it, then sets the object as a property of the top-level window object.</p>
 *         
 *         <script src="https://gist.github.com/4513301.js"></script>
 *         
 *         <p>As a result, you should see the following content set as the body of the HTML page in the
 *             WebBrowser.  Note that we can refer to the "steve" object that we just set directly/globally
 *             because the "window" object's properties are always available directly through the global
 *             namespace in Javascript.</p>
 *         <p><center><img src="http://media.weblite.ca/files/photos/steve-is-34.png"/></center></p>
 * 
 *         <h2>Working with Objects</h2>
 *         
 *         <p>Previously examples showed how to obtain a {@link ca.weblite.codename1.js.JSObject} proxy to a Javascript object.  There are 4 ways to get a {@link ca.weblite.codename1.js.JSObject}:</p>
 *         <ol>
 *             <li>Create an anonymous object: <br/><code>JSObject obj = (JSObject)ctx.get("{}");</code></li>
 *             <li>Reference an existing object directly: <br/><code>JSObject obj = (JSObject)ctx.get("window.location");</code></li>
 *             <li>As the result of a Javascript expression or function call:
 *                 <br/><code>JSObject obj = (JSObject)ctx.get("document.getElementById('mydiv')")</code>
 *             </li>
 *             <li>Retrieve an Object member variable from another JSObject: 
 *                 <br/><code>JSObject obj = (JSObject)otherObj.get("aPropertyThatIsAnObject")</code>
 *             </li>
 *         </ol>
 *         
 *         <p>{@link ca.weblite.codename1.js.JSObject}s are essentially just proxies around a Javascript object.  Any calls to retrieve 
 *             properties from a {@link ca.weblite.codename1.js.JSObject} are just sent directly to the Javascript context, and the result
 *             returned.  The {@link ca.weblite.codename1.js.JSObject} object doesn't store copies the javascript object's properties.  It just
 *             retrieves them as they are required via the {@link ca.weblite.codename1.js.JSObject#get(String)} method.</p>
 *         
 *         <h3>Getting Simple Values</h3>
 *         
 *         <p>You can always retrieve the properties of an object using the {@link ca.weblite.codename1.js.JSObject#get(String)} method.  It takes the name of the property 
 *             as a parameter, and returns its value, converted to the appropriate Java type.  (e.g. if it is a String,
 *             it returns a String, if it is a number it returns a Double, and if it is an Object, it returns an object.</p>
 *         
 *         <p>E.g.</p>
 *         
 *         <p><code><pre>
 * String name = (String)obj.get("name");
 * Double age = (Double)obj.get("age");
 * </pre></code>
 *             <br/>
 *             Is equivalent to the following javascript:
 *             <br/>
 *             <code>
 *                 var name = obj.name;
 *                 var age = obj.age;
 *             </code>
 *             <br/>
 *             Assuming that the <code>obj</code> variable in Java is a proxy for the same obj variable
 *             in the javascript example.
 *         </p>
 *         
 *         <h3>Getting Nested Object Values</h3>
 *         
 *         <p>Often, in Javascript, an object contains a heirarchy of nested child objects.  E.g.</p>
 *         
 *         <p><code><pre>
 * var obj = {
 *     name : 'Steve',
 *     position : {
 *         x : 100,
 *         y : 105,
 *         z : -25
 *     }
 * }
 * </pre></code></p>
 * 
 * <p>In this case you may want to obtain the <var>x</var> coordinate of the nested position object.  {@link JSObject} allows
 *     you to use the dot '.' notation for referencing sub-properties like this.  E.g. <br/>
 *     <code><pre>Double x = (Double)obj.get("position.x")</pre></code>
 * </p>
 * <p>This feature raises the issue of how, then, to access properties that contain a '.' in its name.  E.g.</p>
 * <p><code><pre>
 * var obj = {
 *     name : 'Steve',
 *     position : {
 *         x : 100,
 *         y : 105,
 *         z : -25
 *     },
 *     'position.x' : 200
 * }
 * </pre></code></p>
 * 
 * <p>In this example there is a top-level property named 'position.x' as well as a property at the component address <var>position.x</var>.
 *     This is a contrived example that is meant to be somewhat confusing in order to demonstrate how to differentiate
 *     between requests for properties in the child object heirarchy and top-level properties that happen to 
 *     include a '.' in the property name.</p>
 * 
 * <p>We can force the retrieval of a top-level property by wrapping the <var>key</var> in single quotes:</p>
 * <p><code><pre>Double x1 = (Double)obj.get("'position.x'")</pre></code></p>
 * 
 * <p>This would return <int>200</int> for the above example, whereas:</p>
 * <p><code><pre>Double x2 = (Double)obj.get("position.x")</pre></code></p>
 * <p>Would return <int>100</int></p>.
 *        
 * <h3>Setting Object Values</h3>
 * 
 * <p>The {@link ca.weblite.codename1.js.JSObject#set(String,Object)} method works the same as the {@link ca.weblite.codename1.js.JavascriptContext#set(String,Object)} method except that it treats the local
 *     object as the root node.  It allows you to easily set properties on the object.  Values set here should
 *     be provided using Java values as they will automatically be converted to the appropriate associated Javascript
 *     type.  If you are setting an Object as a value, then you'll need to set it as a {@link ca.weblite.codename1.js.JSObject} and not a string
 *     representation of the object.  This is because Strings will just be converted to Javascript strings.</p>
 * 
 * <p>Properties set via the {@link ca.weblite.codename1.js.JSObject#set(String,Object)} method modify the underlying Javascript object directly so that the change
 *     is immediately effective inside the javascript environment.
 * </p>
 * <p>Just as with the {@link ca.weblite.codename1.js.JSObject#get(String)} method, you can set the values of direct properties or nested properties using
 *     the dot '.' notation.  And just like {@link ca.weblite.codename1.js.JSObject#get(String)}, you can force setting a direct property in cases where the property
 *     name includes a '.', by wrapping the <var>key</var> inside single quotes.
 *     
 * </p>
 * <p>E.g.:</p>
 * <p><code><pre>
 * // Create a team object , and leave city null for now.
 * JSObject blueJays = (JSObject)ctx.get("{name : 'Blue Jays', city : null}");
 * 
 * // Create a city object and leave country null for now.
 * JSObject toronto = (JSObject)ctx.get("{name : 'Toronto', country : null}");
 * 
 * // Create a country object
 * JSObject canada = (JSObject)ctx.get("{name : 'Canada'}");
 * 
 * // Set the team's city to toronto
 * blueJays.set("city", toronto);
 * 
 * // Set toronto's country to canada
 * toronto.set("country", canada);
 * 
 * // Retrieve the name of the country where the blue jays play
 * String countryName = (String)blueJays.get("city.country.name");
 *        // Should contain "Canada"
 * 
 * // Change the name of Canada to "Canuck land" using nested 
 * // dot notation on the blueJays object.
 * 
 * blueJays.set("city.country.name", "Canuck land");
 * 
 * String blueJaysCountry = (String)blueJays.get("city.country.name");
 * String torontoCountry = (String)tornoto.get("country.name");
 * String canadaName = (String)canada.get("name");
 * 
 * //Note that all of these should be equal and contain "Canuck land"
 * </pre></code>
 *         
 *         <h3>Calling Object Methods</h3>
 *         
 *         <p>The {@link ca.weblite.codename1.js.JSObject#call(String,Object)} method allows you to call javascript methods that 
 *             are members of the underlying object.  It arguments are passed as an
 *             Object[] array.  These will be automatically converted from the Java type to the corresponding
 *             Javascript type.  Java type conversion are the same as using the {@link ca.weblite.codename1.js.JavascriptContext#set(String,Object)} method.
 *         </p>
 *         
 *         <p>The following example shows an object with a simple <code>add()</code> method
 *             that just adds two numbers together:</p>
 *         <p><code><pre>
 * JSObject obj = (JSObject)ctx.get("{ add : function(a,b){ return a+b;}}");
 * Double result = (Double)obj.call("add", 
 *     new Object[]{new Integer(1), new Integer(3)}
 * );
 * 
 * // Result should be 4.0
 * </pre></code></p>
 *                
 * <h3>Working with Arrays</h3>
 * 
 * <p>In javascript, arrays are just objects that include a special ability to be iterated.  You can use the alternate
 *     version of {@link ca.weblite.codename1.js.JSObject#get(int)} which takes an <var>int</var> as a parameter to retrieve the elements of an array.</p>
 * 
 * <p>For example, consider the following javascript object:</p>
 * <p><code><pre>
 * var obj = {
 *     name : 'Blue Jays',
 *     players : [
 *         { name : 'George Bell', age : 31},
 *         { name : 'Tony Fernandez', age : 34},
 *         { name : 'Lloyd Moseby', age : 29}
 *     ]
 * }
 * 
 *         </pre></code></p>
 *         
 *         <p>Then assuming we have a {@link ca.weblite.codename1.js.JSObject} proxy for this object, we could loop through the players
 *             array and output the name and age of each player as follows:</p>
 *         
 *         <p><code><pre>
 * JObject players = (JObject)obj.get("players");
 * int len = ((Double)players.get("length")).intValue();
 * for ( int i=0; i&lt;len; i++){
 *     JSObject player = (JSObject)players.get(i);
 *     Log.p("Name : "+player.get("name")+" age : "+player.get("age"));
 * }
 *                 </pre></code>
 *                
 *             
 *             
 *         <h2>Calling Java Methods from Javascript</h2>
 *         
 *         <p>So far, our examples have been limited to Java calling into Javascript.  However, it may be 
 *             useful to be able to also go the other way:  call java methods from Javascript.  Some applications
 *             of this might include:</p>
 *         <ul>
 *             <li>Capturing video, or using the camera on the phone</li>
 *             <li>Getting the phone location</li>
 *             <li>Accessing the file system or storage API</li>
 *         </ul>
 *         
 *         <p>The Codename One JS bridge supports javascript to java method calling by way of the {@link ca.weblite.codename1.js.JSFunction} interface
 *             and the {@link ca.weblite.codename1.js.JSObject#set(String,Object)} methods on the {@link ca.weblite.codename1.js.JSObject} class.  You can implement a {@link ca.weblite.codename1.js.JSFunction}
 *             object and register it as a callback with a {@link ca.weblite.codename1.js.JSObject}, then you will be able to 
 *             execute this object's apply method via a Javascript proxy.</p>
 *         
 *         <p>As an example, let's implement a simple logging function:</p>
 *         
 *         <p><code><pre>
 * JSObject logger = (JSObject)ctx.get("{}");
 * logger.set("log", new JSFunction(){
 * 
 *     public void apply(JSObject self, Object[] args) {
 *         String msg = (String)args[0];
 *         Log.p("[Javascript Logger] "+msg);
 *     }
 *     
 * });
 * 
 * ctx.set("window.logger", logger);
 * 
 * 
 * c.executeAndReturnString("logger.log('This is a test message');");
 * </pre></code></p>
 * 
 * <p>If you execute this code in the simulator, you'll see the following output in the console:</p>
 * 
 * <pre>[EDT] 0:0:0,0 - [Javascript Logger] This is a test message</pre>
 * 
 * <p>Running it on a device will yield similar output in the device log file.</p>
 * 
 * <p>Let's step through this code to see what is happening.  First we create a new, empty javascript object
 *     and wrap it in a JSObject proxy.  Then we use the {@link ca.weblite.codename1.js.JSObject}'s {@link ca.weblite.codename1.js.JSObject#set(String,Object)} method to add an anonymous {@link ca.weblite.codename1.js.JSFunction}
 *     object to it with the propery of "log".  This step registers a method proxy on the Javascript side that acts just
 *     like a normal javascript method, but which actually triggers the {@link ca.weblite.codename1.js.JSFunction}'s {@link ca.weblite.codename1.js.JSFunction#apply(JSObject,Object[])} method.</p>
 * 
 * <p>We then set this <var>logger</var> object to the global javascript scope by making it a direct child
 *     of the <var>window</var> object.  Finally we issue a Javascript method call to <code>logger.log()</code>.  This 
 *     is what effectively calls the apply() method on our {@link ca.weblite.codename1.js.JSFunction} object.</p>
 * 
 * <h3>Caveats</h3>
 * 
 * <p><strong>JSFunction callbacks are executed asynchronously so as to prevent deadlocks.</strong>  This means that you cannot 
 *     return a value from this method using a return statement (hence the reason why the interface definition for {@link ca.weblite.codename1.js.JSFunction#apply(JSObject,Object[])} is <var>void</var>.
 * </p>
 * <p><strong>If you want to return a value back to Javascript, then you'll need to do it by providing a 
 *         callback function as one of the parameters, and call this callback method from inside the {@link ca.weblite.codename1.js.JSFunction#apply(JSObject,Object[])}
 *         method upon completion.</strong></p>
 *         
 *         <h3>Example: Passing a Javascript Callback to Your Callback</h3>
 *         
 *         <p>Since {@link ca.weblite.codename1.js.JSFunction} callbacks are executed asynchronously, if you want to be able to return a result back to Javascript, you will
 *             need to do this via a Javascript callback.  This is quite a common pattern in Javascript since it is single threaded and relies
 *             upon non-blocking patterns.</p>
 *         
 *         <p>As an example, let's create a {@link ca.weblite.codename1.js.JSFunction} callback that adds two numbers together and returns the result to Javascript via a callback:</p>
 *         
 *         <p>First we will create the {@link ca.weblite.codename1.js.JSFunction} object to perform the addition, as follows:</p>
 *         <p><code><pre>
 * WebBrowser b = new WebBrowser(){
 *     protected void onLoad(String url){
 *         JSObject window = (JSObject)ctx.get("window");
 *         window.set("addAsync", new JSFunction(){
 * 
 *             public void apply(JSObject self, final Object[] args) {
 *                 Double a = (Double)args[0];
 *                 Double b = (Double)args[1];
 *                 JSObject callback = (JSObject)args[2];
 * 
 *                 double result = a.doubleValue() + b.doubleValue();
 *                 callback.call(new Object[]{new Double(result)});
 * 
 *             }
 * 
 *         });
 *     }
 * };
 * 
 * b.setURL("jar:///ca/weblite/codename1/tests/AddAsync.html");
 *                 </pre></code></p>
 *                 <p>In this snippet, we start by obtaining a reference to the "window" object.  We then add a method to this object named "addAsync".  This method is a {@link ca.weblite.codename1.js.JSFunction}
 *                     object that we implement inline.  The apply() method of the {@link ca.weblite.codename1.js.JSFunction} object is the Java method that will be executed when the addAsync method is called 
 *                     from Javascript.  In this case the addAsync method expects three parameters:</p>
 *                 <ol>
 *                     <li>The two numbers that are being added together.</li>
 *                     <li>A Javascript callback method that will be executed when completed and passed the result of the addition
 *                     as a parameter.</li>
 *                 </ol>
 *                 <p>Notice that all numerical arguments are converted to Java Double objects, and the callback function is converted to a {@link ca.weblite.codename1.js.JSObject} object.  Also notice the use
 *                     of <var>callback.call()</var>, which just calls the <var>callback</var> as a function itself.  With this variant of the <var>call()</var> method,
 *                     the <var>window</var> object is used as <var>this</var>.  Notice also that we pass the result inside an <var>Object[]</var> array.  This array will be expanded to
 *                     the direct javascript function parameters.  (i.e. it will not pass an array as the parameter to the javascript method, the array elements are extracted
 *                     and passed individually.</p>
 *                 
 *                 
 *                 <p>Now, let's look at the HTML page contents for our example:</p>
 *                 <p><code><pre>
 * &lt;!DOCTYPE html&gt;
 * &lt;html&gt;
 *     &lt;head&gt;
 *         &lt;title&gt;Addition Example&lt;/title&gt;
 *     &lt;/head&gt;
 *     &lt;body&gt;
 *         &lt;div&gt;Addition Example&lt;/div&gt;
 *         &lt;p&gt;&lt;input type="text" size="4" id="input1"/&gt; +
 *             &lt;input type="text" size="4" id="input2"/&gt; =
 *             &lt;span id="result"&gt;&lt;/span&gt;
 *         &lt;/p&gt;
 *         &lt;p&gt;&lt;button id="calculate"&gt;Calculate&lt;/button&gt;&lt;/p&gt;
 *         &lt;script src="AddAsync.js"&gt;&lt;/script&gt;
 *     &lt;/body&gt;
 * &lt;/html&gt;
 *                         </pre></code></p>
 *                         <p>Our HTML simply includes two text fields (to input the values to be added together), a button to initiate the calculation,
 *                             and a &lt;span&gt; tag where the result will be placed when the calculation is complete.</p>
 *                         <p>Finally it includes the AddAsync.js Javascript file (which is placed in the same directory as the AddAsync.html file.  Its
 *                             contents are as follows:</p>
 *                         <p><code><pre>
 * 
 * document
 *     .getElementById('calculate')
 *     .addEventListener('click', function(){
 *         var aField = document.getElementById('input1');
 *         var bField = document.getElementById('input2');
 *         var a = parseFloat(aField.value);
 *         var b = parseFloat(bField.value);
 *         window.addAsync(a, b, function(result){
 *            document.getElementById('result').innerHTML = result;
 *         });
 *     }, true);
 * 
 *                         </pre></code></p>
 *                                 
 *                         <p>This script attaches an event handler to the <var>calculate</var>
 *                             button that gets the values from the two input fields and 
 *                             passes it to the <var>window.addAsync()</var> method for calculation.  The <var>addAsync()</var>
 *                             method is actually our java <var>JSFunction</var> that we implemented earlier.  
 *                         </p>
 *                         
 *                         <p>
 *                             One small word about the placement of these files:  This example is taken from a class <var>ca.weblite.codename1.tests.CodenameOneTests</var>.
 *                             The AddAsync.html and AddAsync.js files are included in the same directory as the CodenameOneTests.java file (
 *                             i.e. /ca/weblite/codename1/tests).  We used the WebBrowser's <var>setURL()</var> method to load the AddAsync.html file from an 
 *                             absolute path using <var>jar:</var> protocol.  Currently this is the best way of loading local HTML files into
 *                             a WebBrowser object (i.e. use the jar: protocol and provide an absolute path).
 *                         </p>
 *                         
 *                         <p>The result of running this app is as follows:</p>
 *                         <p><center><img src="http://media.weblite.ca/files/photos/AddAsync.png?max_width=640"/></center></p>
 * 
 * <h3>Example: Exposing the Camera to Javascript</h3>
 * 
 * <p>The following creates a Javascript function for taking photos on a mobile device.  It involves a simple webpage with a "Capture" button.  When the user 
 *     clicks this button, it will dispatch a function call to CodenameOne to access the device's camera.  After the user takes a picture, CodenameOne will 
 *     execute a Javascript callback to add the picture to the webpage.</p>
 * 
 * <p>The HTML page source is as follows:</p>
 * <script src="https://gist.github.com/4610833.js"></script>
 * 
 * <p>This loads the CameraExample.js script:</p>
 * <code><pre>
 * document.getElementById('capture')
 *     .addEventListener('click', function(){
 *         camera.capture(function(url){
 *             if ( url == null ){
 *                 // No image was provided
 *                 return;
 *             }
 *             var results = document.getElementById('results');
 *             results.appendChild(document.createTextNode("testing"));
 *             var img = document.createElement('img');
 *             img.setAttribute('src',url);
 *             img.setAttribute('width', '100');
 *             img.setAttribute('height', '100');
 *             results.appendChild(img);
 *         })
 *     }, true);
 * </pre></code>
 * 
 * <p>The CameraExample.js script attaches a listener to the 'click' event of the "Capture" button which simply calls the <code>camera.capture()</code> method, 
 *     which is actually a JSFunction that has been registered with the Javascript runtime.  This actually calls into Java.</p>
 * <p>We pass a callback function into <code>camera.capture()</code> which will be executed upon successfully completion of the camera.  This is a common
 *     programming pattern in Javascript.  If a non-null URL is passed to this callback function, it is expected to be the URL of the image (it will be
 *     a local file URL.</p>
 * 
 * <p>The Java code that powers this example is as follows:</p>
 * <script src="https://gist.github.com/4611006.js"></script>
 * 
 * <p>This example puts together most of the features of the CodenameOne-JS library.</p>
 * <ol>
 *     <li>It creates a new JSObject from within Java code to serve as the camera object.</li>
 *     <li>It registers a JSFunction callback as a Javascript function which is added as a method to the camera object.</li>
 *     <li>It shows the use of the <code>call()</code> method of <code>JSObject</code> to call the callback function that was
 *         provided by Javascript from inside
 *         the JSFunction's <code>apply()</code> method.</li>
 * </ol>
 *         
 *     
 */
package ca.weblite.codename1.js;


/**
 *  <p>The JSFunction interface allows you to implement functions in Java that can
 *  be called from Javascript.  You can assign any JSFunction object to be a member
 *  method of an existing JSObject via the {@link JSObject#set(String,Object) JSObject.set()} method.  Then the function
 *  can be called from javascript just like any other Javascript method.  JSFunction
 *  methods are called asynchronously from Javascript to prevent deadlocks.  If you
 *  require a return value to Javascript, you can do that by passing a callback 
 *  function which is called by the JSFunction with some parameters.</p>
 *  
 *  <p>The following example, adds a camera object to the Javascript environment
 *  that has a capture() method, which can be used to capture images using the
 *  device's camera:</p>
 *  
 *  <code><pre>
 *  // Create a new Javascript object "camera"
 *  final JSObject camera = (JSObject)ctx.get("{}");
 *  
 *  // Create a capture() method on the camera object
 *  // as a JSFunction callback.
 *  camera.set("capture", new JSFunction(){
 *  
 *      public void apply(JSObject self, final Object[] args) {
 *          Display.getInstance().capturePhoto(new ActionListener(){
 *  
 *              public void actionPerformed(ActionEvent evt) {
 *                  
 *                  String imagePath = (String)evt.getSource();
 *                  
 *                  // Get the callback function that was provided
 *                  // from javascript
 *                  JSObject callback = (JSObject)args[0];
 *                  
 *                  ctx.call(
 *                          callback, // The function
 *                          camera,   // The "this" object
 *                          new Object[]{"file://"+imagePath}  // Parameters
 *                  );
 *              }
 *              
 *          });
 *      }
 *      
 *  });
 *  
 *  
 *  // Add the camera object to the top-level window object
 *  ctx.set("window.camera", camera);
 *  
 *  
 *  </pre></code>
 *  <p>We can then capture photos directly from Javascript using a function similar to the following:</p>
 *  <code><pre>
 *  camera.capture(function(url){
 *      if ( url == null ){
 *          // No image was captured
 *          return;
 *      }
 *  
 *      // Fetch the preview &lt;img&gt; tag.
 *      var image = document.getElementById('preview-image');
 *      // Set the preview URL to the image that was taken.
 *      image.src = url;
 *  });
 *  </pre></code>
 *  @author shannah
 */
public interface JSFunction {

	public void apply(JSObject self, Object[] args);
}
