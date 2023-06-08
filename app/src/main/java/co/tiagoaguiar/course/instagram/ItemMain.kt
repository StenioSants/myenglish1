package co.tiagoaguiar.course.instagram

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemMain : AppCompatActivity(), OnClickedListener {


    private lateinit var rvItems: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_main)

        val iconItems = mutableListOf<IconItem>()
        iconItems.add(
            IconItem(
                id = 1,
                drawableId = R.drawable.ic_baseline_card_membership_24,
                textStringId = R.string.flashCards,
                color = Color.WHITE,
            )
        )
        iconItems.add(
            IconItem(
                id = 2,
                drawableId = R.drawable.ic_baseline_font_download_24,
                textStringId = R.string.essentialWords,
                color = Color.WHITE,
            )
        )

        iconItems.add(
            IconItem(
                id = 3,
                drawableId = R.drawable.ic_baseline_audiotrack_24,
                textStringId = R.string.audioBooks,
                color = Color.WHITE,
            )
        )
        iconItems.add(
            IconItem(
                id = 4,
                drawableId = R.drawable.ic_baseline_menu_book_24,
                textStringId = R.string.textReader,
                color = Color.WHITE,
            )
        )


        val adapter = MainAdapter(iconItems, this)
        rvItems = findViewById(R.id.rv_items)
        rvItems.adapter = adapter
        rvItems.layoutManager = GridLayoutManager(this, 2)
    }

    override fun onClick(id: Int) {

        when (id) {
            1 -> {
                val i = Intent(this, FlashCards::class.java)
                startActivity(i)
            }
            2 -> {
                val i = Intent(this, EssentialWords::class.java)
                startActivity(i)
            }
            3 -> {
                val i = Intent(this, AudioBooks::class.java)
                startActivity(i)
            }
            4 -> {
                val i = Intent(this, TextReader::class.java)
                startActivity(i)
            }

        }

    }

    private inner class MainAdapter(
        private val iconItems: List<IconItem>,
        private val onClickedListener: OnClickedListener
    ) :
        RecyclerView.Adapter<MainAdapter.MainViewHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
            val view = layoutInflater.inflate(R.layout.item_funtion, parent, false)
            return MainViewHolder(view)

        }

        override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
            val itemCurrent = iconItems[position]
            holder.bind(itemCurrent)


        }

        override fun getItemCount(): Int {
            return iconItems.size

        }

        private inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            @SuppressLint("ResourceType")
            fun bind(item: IconItem) {
                val img: ImageView = itemView.findViewById(R.id.img_icon)
                val txt: TextView = itemView.findViewById(R.id.txt_icon)
                val container: LinearLayout = itemView.findViewById(R.id.layout_icon)

                img.setImageResource(item.drawableId)
                txt.setText(item.textStringId)
                container.setBackgroundColor(item.color)
                container.setBackgroundResource(R.drawable.icon_backgorund)




                container.setOnClickListener {
                    onClickedListener.onClick(item.id)
                }
            }
        }
    }
}