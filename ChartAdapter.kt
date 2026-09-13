package com.jasstrademy.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.recyclerview.widget.RecyclerView

class ChartAdapter(private val coinList: List<String>) : RecyclerView.Adapter<ChartAdapter.ChartViewHolder>() {

    class ChartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val webView: WebView = itemView.findViewById(R.id.chartWebView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChartViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_chart, parent, false)
        return ChartViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChartViewHolder, position: Int) {
        val symbol = coinList[position]

        val htmlData = """
        <!DOCTYPE html>
        <html>
        <head>
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <style>
                html, body { margin: 0; padding: 0; width: 100%; height: 100%; overflow: hidden; background-color: #131722; }
                .tradingview-widget-container { width: 100%; height: 100%; }
            </style>
        </head>
        <body>
            <div class="tradingview-widget-container">
                <div id="tradingview_chart"></div>
                <script type="text/javascript" src="https://s3.tradingview.com/tv.js"></script>
                <script type="text/javascript">
                    new TradingView.widget({
                        "autosize": true,
                        "symbol": "BINANCE:${symbol}USDT",
                        "interval": "15",
                        "timezone": "Asia/Kolkata",
                        "theme": "dark",
                        "style": "1",
                        "locale": "en",
                        "toolbar_bg": "#f1f3f6",
                        "enable_publishing": false,
                        "hide_side_toolbar": false,
                        "allow_symbol_change": true,
                        "container_id": "tradingview_chart"
                    });
                </script>
            </div>
        </body>
        </html>
        """.trimIndent()

        holder.webView.settings.javaScriptEnabled = true
        holder.webView.settings.domStorageEnabled = true
        holder.webView.webViewClient = WebViewClient()
        holder.webView.loadDataWithBaseURL("https://www.tradingview.com", htmlData, "text/html", "UTF-8", null)
    }

    override fun getItemCount(): Int {
        return coinList.size
    }
}
