import com.google.gson.annotations.SerializedName

/*
Copyright (c) 2021 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */


data class Daily (

	@SerializedName("dt") val dt : Int,
	@SerializedName("sunrise") val sunrise : Int,
	@SerializedName("sunset") val sunset : Int,
	@SerializedName("moonrise") val moonrise : Int,
	@SerializedName("moonset") val moonset : Int,
	@SerializedName("moon_phase") val moon_phase : Double,
	@SerializedName("temp") val temp : Temp,
	@SerializedName("feels_like") val feels_like : Feels_like,
	@SerializedName("pressure") val pressure : Int,
	@SerializedName("humidity") val humidity : Int,
	@SerializedName("dew_point") val dew_point : Double,
	@SerializedName("wind_speed") val wind_speed : Double,
	@SerializedName("wind_deg") val wind_deg : Int,
	@SerializedName("wind_gust") val wind_gust : Double,
	@SerializedName("weather") val weather : List<Weather>,
	@SerializedName("clouds") val clouds : Int,
	@SerializedName("pop") val pop : Int,
	@SerializedName("uvi") val uvi : Double
)