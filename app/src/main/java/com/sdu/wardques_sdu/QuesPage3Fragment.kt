package com.sdu.wardques_sdu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.sdu.wardques_sdu.databinding.FragmentQuesPage1Binding
import com.sdu.wardques_sdu.databinding.FragmentQuesPage3Binding

class QuesPage3Fragment:Fragment() {

    private lateinit var binding: FragmentQuesPage3Binding
    val list = ArrayList<Ques>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentQuesPage3Binding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val quesTitle = "다음의 단어의\n상반되는 단어를 고르세요."
        val maps = listOf<Pair<String, String>>(
            Pair("Top", "Bottom"),
            Pair("Water", "Fire"),
            Pair("Country", "City"),
            Pair("Fat", "Fit")
        )

        for (pair in maps) {
            list.add(Ques(quesTitle, mapOf(pair)))
        }
        list.shuffle()

        binding.answardBtn1.text = filterString(list[0].ward_answar.keys.toString())
        binding.answardBtn2.text = filterString(list[1].ward_answar.keys.toString())
        binding.answardBtn3.text = filterString(list[2].ward_answar.keys.toString())
        binding.answardBtn4.text = filterString(list[3].ward_answar.keys.toString())

        list.shuffle()

        val ward = list[0].ward_answar.values.toString()
        binding.ques.text = list[0].ques
        binding.ward.text = ward.substring(1, ward.length-1)

        binding.answardBtn1.setOnClickListener {
            if(list[0].ward_answar[binding.answardBtn1.text.toString()] == null){ makeAlertDialog("틀리셨습니다.") }
            else{ makeAlertDialog("정답입니다.") }
        }
        binding.answardBtn2.setOnClickListener {
            if(list[0].ward_answar[binding.answardBtn2.text.toString()] == null){ makeAlertDialog("틀리셨습니다.") }
            else{ makeAlertDialog("정답입니다.") }
        }
        binding.answardBtn3.setOnClickListener {
            if(list[0].ward_answar[binding.answardBtn3.text.toString()] == null){ makeAlertDialog("틀리셨습니다.") }
            else{ makeAlertDialog("정답입니다.") }
        }
        binding.answardBtn4.setOnClickListener {
            if(list[0].ward_answar[binding.answardBtn4.text.toString()] == null){ makeAlertDialog("틀리셨습니다.") }
            else{ makeAlertDialog("정답입니다.") }
        }
    }

    private fun filterString(result: String):String = result.substring(1, result.length-1)

    private fun makeAlertDialog(result:String){
        AlertDialog.Builder(this.requireContext())
            .setTitle("결과")
            .setMessage(result)
            .show()
    }
}