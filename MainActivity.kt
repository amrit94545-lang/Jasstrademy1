package com.jasstrademy.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val coins = listOf(
            "BTC", "ETH", "BNB", "SOL", "XRP", "ADA", "DOGE", "AVAX", "DOT", "LINK",
            "MATIC", "SHIB", "LTC", "TRX", "BCH", "NEAR", "UNI", "ICP", "APT", "FIL",
            "STX", "ATOM", "XMR", "ETC", "OKB", "IMX", "HBAR", "KAS", "INJ", "OP",
            "LDO", "CRO", "TIA", "SEI", "GRT", "RNDR", "THETA", "EGLD", "ALGO", "RUNE",
            "FLOW", "FTM", "PEPE", "SAND", "MANA", "EOS", "AAVE", "KAVA", "SNX", "XTZ",
            "AXS", "GALA", "MINA", "NEO", "CFX", "ORDI", "BONK", "FLOKI", "WIF", "JUP",
            "STRK", "BEAM", "PYTH", "DYDX", "CRV", "CHZ", "COMP", "ROSE", "FET", "AGIX",
            "GMX", "ZIL", "LUNC", "LUNA", "IOTA", "1INCH", "ENJ", "CAKE", "KSM", "DASH",
            "HOT", "ZEC", "QTUM", "XEC", "TFUEL", "WOO", "CELO", "BAT", "AR", "ASTR",
            "ANKR", "IOTX", "RVN", "ONE", "BAND", "SFP", "YFI", "AUDIO", "SUSHI", "SKL",
            "ICX", "KNC", "ONT", "MASK", "GLMR", "MOVR", "GNS", "SPELL", "MAGIC", "RPL",
            "SSV", "HIGH", "ACH", "CKB", "UMA", "C98", "API3", "BLUR", "MEME", "ALICE",
            "STORJ", "BAL", "TRB", "BICO", "LRC", "RLC", "SYS", "PERP", "CELR", "DGB",
            "ZEN", "CTSI", "STRAX", "UTK", "PROS", "COTI", "REQ", "TLM", "REN", "SXP",
            "OCEAN", "BEL", "BAKE", "ALPHA", "HARD", "UNFI", "LIT", "BADGER", "ID"
        )

        val adapter = ChartAdapter(coins)
        recyclerView.adapter = adapter
    }
}
