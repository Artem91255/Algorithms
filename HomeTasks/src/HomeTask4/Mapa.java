package HomeTask4;

public class Mapa <K, V>{
    Node <K, V>[] nodes = new Node[16];

    //Добавление элемента
    public V put(K key, V value){
        V result = null; //переменная result. нициализация
        Node<K, V> inputNode = new Node<>(key, value); //создаем объект нода с полями key b value
        Integer hash16 = inputNode.key.hashCode()%16; //создаем переменную hash16. ее значение: остаток от деления на 16 хэшкода ключа ноды
        if(nodes[hash16] != null){   //Если если нода с индексом hash16 не равна нулю
            Node<K,V> currentNode = nodes[hash16]; //создаем объект currentNode типа Node и присваиваем ему значение ноды с индексом hash16
            while (currentNode !=null){  //пока значение currentNode не равно нулю
                if(currentNode.key ==key){ //Если ключ currentNode равен значению key, которое мы передали в метод, то
                    result = currentNode.value; //переменной результат присваивается значение currentNode.value
                    currentNode.value = value; //currentNode.value присваивается значение value, которое мы изначально передавали в метод
                    return result; //Возвращаем result
                } //продолжаем когда перестает выполняться условие if(если currentNode.key !=key )
                currentNode = currentNode.nextNode; //Ноде currentNode присваивается значение  ноды currentNode.nextNode для последующей работы с новым значением
            } //окончание цикла while
            inputNode.nextNode = nodes[hash16]; // Ноде inputNode.nextNode присваивается значение ноды nodes с индексом hash16
        } //Продолжаем когда перестает выполнятся условия if(nodes[hash16] != null)
        nodes[hash16] = inputNode; //ноде nodes с индексом hash16 присваивается значение inputNode
        return result; // возвращаем значение result
    }

    //Получение занчения соответствующее ключу

    public V get(K key) {
        Integer index = key.hashCode() % 16; //Создаем переменную index  присваиваем ей значение: остаток от деления на 16 хэш-кода значения, которое мы передаем в метод
        Node<K, V> currentNode = nodes[index]; //Создаем объект типа нода currentNode и присваиваем ей значение ноды с индексом index
        while (currentNode != null) { //пока currentNode не равна null
            if (currentNode.key == key) { //если currentNode.key равен значению, которое мы передали в метод
                return currentNode.value; //возвращаем значение currentNode
            }
            currentNode = currentNode.nextNode; //Ноде currentNode присваивается значение  ноды currentNode.nextNode для последующей работы с новым значением
        }
        return null;
    }

    //Удаление элемента с соответствующим ключём
    public V remove(K key) {
        Integer index = key.hashCode() % 16;
        Node<K, V> currentNode = nodes[index];
        Node<K, V> previousNode = null;
        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                V tmp = currentNode.value;
                if (previousNode == null)
                    nodes[index] = currentNode.nextNode;
                else if (currentNode.nextNode == null)
                    previousNode.nextNode = null;
                else
                    previousNode.nextNode = currentNode.nextNode;
                return tmp;
            }
            previousNode = currentNode;
            currentNode = currentNode.nextNode;
        }
        return null;
    }
//замена значения
    public V replays(K key, V value) {
        Integer index = key.hashCode() % 16;
        Node<K, V> currentNode = nodes[index];
        while (currentNode != null) {
            if (currentNode.key == key) {
                currentNode.value = value;
                return currentNode.value;
            }
            currentNode = currentNode.nextNode;
        }
        return null;
    }
    //количество элементов
    public int size(){
        int result = 0;
        for (int i = 0; i < 16; i++){
            Node<K, V> currentNode = nodes[i];
            while (currentNode != null){
                result ++;
                currentNode = currentNode.nextNode;
            }
        }
        return result;
    }


//проверка наличия ключа
    public boolean containsKey(K key){
        Integer index = key.hashCode() % 16;
        Node<K, V> currentNode = nodes[index];
        while (currentNode != null) {
            if (currentNode.key == key) {
                return true;
            }
            currentNode = currentNode.nextNode;
        }
        return false;
    }
    //проверка наличия значения
    public boolean containsValue(V value){
        for (int i = 0; i < 16; i++){
            Node<K, V> currentNode = nodes[i];
            if (currentNode != null && currentNode.value == value){
                return true;
            }
        }
        return false;
    }

}



