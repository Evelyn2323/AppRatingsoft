import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.appratingsoft.databinding.FragmentConfiguracionBinding

class ConfiguracionFragment : Fragment() {

    private lateinit var binding: FragmentConfiguracionBinding
    private lateinit var viewModel: ConfiguracionViewModel
    private lateinit var adapter: ConfiguracionAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentConfiguracionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ConfiguracionViewModel::class.java)
        adapter = ConfiguracionAdapter()

        // Configura el RecyclerView con el adapter
        binding.recyclerViewConfiguracion.adapter = adapter

        // Aquí puedes configurar otros elementos de la interfaz de usuario y manejar eventos
    }
}
