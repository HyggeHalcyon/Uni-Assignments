public class Main {
    public static void main(String[] args) {
        Task1();
        Task2();
    }

    /*
    Not really the best way to implement it,
    but I was racing against time, so it'll work
    though the implementation was very specific
    for the use case
    */
    public static void Task1(){
        Graph graph = new Graph();

        Vertice surabaya = new Vertice("Surabaya");
        Vertice sidoarjo = new Vertice("Sidoarjo");
        Vertice malang = new Vertice("Malang");
        Vertice blitar = new Vertice("Blitar");
        Vertice tulungagung = new Vertice("Tulungagung");
        Vertice trenggalek = new Vertice("Trenggalek");
        Vertice ponorogo = new Vertice("Ponorogo");
        Vertice madiun = new Vertice("Madiun");
        Vertice kediri = new Vertice("Kediri");
        Vertice mojokerto = new Vertice("Mojokerto");
        Vertice nganjuk = new Vertice("Nganjuk");
        Vertice ngawi = new Vertice("Ngawi");
        Vertice bojonegoro = new Vertice("Bojonegoro");
        Vertice lamongan = new Vertice("Lamongan");
        Vertice gresik = new Vertice("Gresik");

        graph.addVertice(new Vertice[] {
                surabaya,
                sidoarjo,
                malang,
                blitar,
                tulungagung,
                trenggalek,
                ponorogo,
                madiun,
                kediri,
                mojokerto,
                nganjuk,
                ngawi,
                bojonegoro,
                lamongan,
                gresik
        });

        graph.addEdge(new Edge[] {
                new Edge(surabaya, sidoarjo, 20),
                new Edge(sidoarjo, malang, 60),
                new Edge(malang, blitar, 55),
                new Edge(blitar, tulungagung, 30),
                new Edge(surabaya, mojokerto, 40),
                new Edge(mojokerto, kediri, 60),
                new Edge(mojokerto, nganjuk, 65),
                new Edge(kediri, tulungagung, 35),
                new Edge(nganjuk, kediri, 30),
                new Edge(nganjuk, madiun, 40),
                new Edge(madiun, nganjuk, 40),
                new Edge(madiun, ponorogo, 32),
                new Edge(ponorogo, trenggalek, 36),
                new Edge(trenggalek, tulungagung, 20),
                new Edge(surabaya, gresik, 20),
                new Edge(gresik, lamongan, 25),
                new Edge(lamongan, bojonegoro, 60),
                new Edge(bojonegoro, ngawi, 60),
                new Edge(ngawi, madiun, 30),
        });

        // so it will be two-way direction edge (i.e. undirected)
        // consumes more memory, but at the moment I can't be bothered with
        // changing the logic/flow and the edge struct of the shortest path algorithm
        // so for now it'll work
        for(Edge edge: graph.cloneEdges()){
            // swap between dest and src
            graph.addEdge(new Edge(edge.dest, edge.src, edge.weight));
        }

        // expected output from task
        graph.DjikstraTransit(surabaya, new Vertice[] {
                sidoarjo,
                ngawi,
                tulungagung
        });

        // additional testing
        graph.DjikstraTransit(nganjuk, new Vertice[]{
                bojonegoro,
                kediri,
                ponorogo
        });
    }

    public static void Task2(){
        // those who has childes
        TreeNode root = new TreeNode("Felis Catus", Breed.NONE);
        TreeNode turkishAngora = new TreeNode("Turkish Angora", Breed.WESTERN);
        TreeNode persian = new TreeNode("Persian", Breed.PERSIANS);
        TreeNode britishShorthair = new TreeNode("British Shorthair", Breed.PERSIANS);
        TreeNode egyptianMau = new TreeNode("Egyptian Mau", Breed.EXOTIC);
        TreeNode siamese = new TreeNode("Siamese", Breed.EASTERN);

        // childes
        TreeNode ragdool = new TreeNode("Ragdoll", Breed.WESTERN);
        TreeNode exoticShorthair = new TreeNode("Exotic Shorthair", Breed.PERSIANS);
        TreeNode himalayan = new TreeNode("Himalayan", Breed.PERSIANS);
        TreeNode scottishFold = new TreeNode("Scottish Fold", Breed.PERSIANS);
        TreeNode bengal = new TreeNode("Bengal", Breed.EXOTIC);
        TreeNode savannah = new TreeNode("Savannah", Breed.EXOTIC);
        TreeNode birman = new TreeNode("Birman", Breed.EASTERN);
        TreeNode orientalShorthair = new TreeNode("Oriental Shorthair", Breed.EASTERN);
        TreeNode peterbald = new TreeNode("Peterbald", Breed.EASTERN);

        // solo mother
        TreeNode norwegianForest = new TreeNode("Norwegian Forest", Breed.WESTERN);
        TreeNode maineCoon = new TreeNode("Maine Coon", Breed.WESTERN);
        TreeNode siberian = new TreeNode("Siberian", Breed.WESTERN);
        TreeNode americanShorthair = new TreeNode("American Shorthair", Breed.WESTERN);
        TreeNode russianBlue = new TreeNode("Russian Blue", Breed.WESTERN);
        TreeNode abyssinian = new TreeNode("Abyssinian", Breed.WESTERN);
        TreeNode burmese = new TreeNode("Burmese", Breed.EASTERN);

        root.addChild(new TreeNode[] {
                // those who has childes
                turkishAngora,
                persian,
                britishShorthair,
                egyptianMau,
                siamese,

                // solo mothers
                norwegianForest,
                maineCoon,
                siberian,
                americanShorthair,
                russianBlue,
                abyssinian,
                burmese
        });

        // adding childes
        turkishAngora.addChild(ragdool);
        persian.addChild(new TreeNode[]{
                exoticShorthair,
                himalayan
        });
        britishShorthair.addChild(scottishFold);
        egyptianMau.addChild(new TreeNode[]{
                bengal,
                savannah
        });
        siamese.addChild(new TreeNode[]{
                birman,
                orientalShorthair,
                peterbald
        });

        // expected findings from task
        persian.findSimilar();
        ragdool.findSimilar();
        birman.findSimilar();

        // additional testing
        siberian.findSimilar();
        burmese.findSimilar();
        root.findSimilar();
    }
}
