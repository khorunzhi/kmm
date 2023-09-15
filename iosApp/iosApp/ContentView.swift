import SwiftUI
import shared

struct ContentView: View {
    
    let vm = shared.Di().featureViewModel(id: 10)

	var body: some View {
        Text(String(vm.id))
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
