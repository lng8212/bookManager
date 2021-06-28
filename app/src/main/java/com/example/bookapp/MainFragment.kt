package com.example.bookapp

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.bookapp.databinding.FragmentMainBinding
import com.example.bookapp.model.Book
import com.example.bookapp.recyclerview.BookAdapter
import com.example.bookapp.recyclerview.BookCallback
import com.example.bookapp.recyclerview.CustomItemAnimator


class MainFragment : Fragment(), BookCallback {

    private lateinit var binding: FragmentMainBinding
    private lateinit var rvBooks: RecyclerView
    private lateinit var bookAdapter: BookAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        setupBookAdapter()
        setupSearchView()
        setRecyclerViewItemTouchListener()
        binding.imageButton.setOnClickListener(){
            addNew()
        }

    }
    private fun addNew(){
        val mDialogView = LayoutInflater.from(view?.context).inflate(R.layout.fragment_add_dialog,null)
        val mBuilder = AlertDialog.Builder(view?.context).setView(mDialogView)
        val mAlertDialog =mBuilder.show()
        mDialogView.findViewById<ImageView>(R.id.btnSumbitnew).setOnClickListener(){
            mAlertDialog.dismiss()
            val title = mAlertDialog.findViewById<EditText>(R.id.titlenew).text.toString()
            val author = mAlertDialog.findViewById<EditText>(R.id.authornew).text.toString()
            val descrip = mAlertDialog.findViewById<EditText>(R.id.desnew).text.toString()
            val page = mAlertDialog.findViewById<EditText>(R.id.pagesnew).text.toString().toInt()
            val review = mAlertDialog.findViewById<EditText>(R.id.reviewernew).text.toString().toInt()
            val rating = mAlertDialog.findViewById<EditText>(R.id.ratingnew).text.toString().toFloat()
            val img = mAlertDialog.findViewById<EditText>(R.id.imagenew).text.toString().toInt()
            MainActivity.mdata.add(0,Book(title,descrip,author,"",page,review,rating,img))
            bookAdapter.notifyItemInserted(0)

        }
    }
    private fun setupSearchView(){
        binding?.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                bookAdapter?.getFilter()?.filter(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                bookAdapter?.getFilter()?.filter(newText)
                return true
            }
        })
    }


    private fun setupBookAdapter() {
        bookAdapter = BookAdapter(MainActivity.mdata, this)
        rvBooks.adapter = bookAdapter

    }



    private fun initViews() {
        rvBooks = binding.rvBook
        rvBooks.setHasFixedSize(true)
        rvBooks.itemAnimator = CustomItemAnimator()

    }

    private fun setRecyclerViewItemTouchListener() {
        var itemTouch = object : ItemTouchHelper.SimpleCallback(0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val pos = viewHolder.adapterPosition
                MainActivity.mdata.removeAt(pos)
                bookAdapter.notifyItemRemoved(pos)

            }
        }
        val itemTouchHelper = ItemTouchHelper(itemTouch)
        itemTouchHelper.attachToRecyclerView(rvBooks)
    }


    override fun sendData(a: Book) {
        val bundle = Bundle()
        bundle.putSerializable("bookObject",a)
        Navigation.findNavController(binding.root).navigate(R.id.action_blankFragment_to_fragmentDetail,bundle)
    }


}