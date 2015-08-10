#OpenWeatherMapAPI

OpenWeatherMapAPI is an open-source android library for fetching weather information [OpenWeatherMap][1] using simple Asynchtask callbacks.

Its Main purpose is to use OpenWeatherMap API requests with ease in a less lines of code. 

This includes following:

 - [Current weather data][2] (Access current weather data for any location on Earth)
 - [5 day / 3 hour forecast][3] (5 day forecast informations)
 - [Call 16 day / daily forecast data][4]  (16 day forecasts/daily forecast informations)


##Usage

You can take a look at the detailed example usage project .

#### 1. Import Module in workspace

#### 2. Add as Module in project dependancy

#### 3. Implementing interface for callback
```
YourActivity implements Response_Interface 

//you will get callback 
onCompeleteRequest(Response_Object mResponseObject)

```
#### 4. Making a request & get Response
```
RequestParams requestParams = new RequestParams();
requestParams.put(OWWeather_API_Constant.Q, "London,uk");
requestParams.put(OWWeather_API_Constant.ID, "2172797");
requestParams.put(OWWeather_API_Constant.LATITUDE, latitude);
requestParams.put(OWWeather_API_Constant.LONGITUDE, longitude);
requestParams.put(OWWeather_API_Constant.ZIP,"94040,us");

// Use different method as per requirement   
RequestAPI.getWeather(this,requestParams,this,true);
RequestAPI.getForcastFor5days(this, requestParams, this, true);
RequestAPI.getForcastFor16days(this, requestParams, this, true);
 
//Finally you will get compelete json object in onCompeleteRequest method. :)


```
Please check [OpenWeatherMap Current weather API][2] for request and resonse parameters.


##Compatibility

 - Android 2.3.3+

##TODOs

- Add Example project on how to use this library.



##Contributing and notes

 - If you like this library, please consider giving it a Github star.

Pull requests are very welcome expecting you follow few rules:

 - Document your changes in a code comments and Git commit message
 
  
## Also you can refere  [iPhone OWMAPIManager][6] 

##License
The MIT License (MIT)

Copyright (c) 2015 Parag Chauhan

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.


  [1]:http://openweathermap.org/api
  [2]:http://openweathermap.org/current
  [3]:http://openweathermap.org/forecast5
  [4]:http://openweathermap.org/forecast16
  [5]:http://openweathermap.org/api
  [6]:https://github.com/Darshanptl7500/OWMAPIManager
