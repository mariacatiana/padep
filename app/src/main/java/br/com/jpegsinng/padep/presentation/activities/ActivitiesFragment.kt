package br.com.jpegsinng.padep.presentation.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.jpegsinng.padep.databinding.FragmentActivitiesBinding
import br.com.jpegsinng.padep.utils.MockActivitiesItems


class ActivitiesFragment : Fragment() {
    private var _binding: FragmentActivitiesBinding? = null
    private val binding: FragmentActivitiesBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentActivitiesBinding.inflate(
        inflater,
        container,
        false
    ).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val classesRecyclerView = binding.classesRecyclerView
        classesRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        val classesItems = MockActivitiesItems.getClassesActivities() // Obtendo os dados mockados
        val classesAdapter = ClassesActivitiesAdapter(classesItems) {
            Toast.makeText(context, "Baixando", Toast.LENGTH_SHORT).show()
        }
        classesRecyclerView.adapter = classesAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}