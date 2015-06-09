//C，类别集合，D，用于训练的文本文件集合
TrainMultiNomialNB(C,D) {
    // 单词出现多次，只算一个
    V←ExtractVocabulary(D)
    // 单词可重复计算
    N←CountTokens(D)
    for each c∈C
        // 计算类别c下的单词总数
        Nc←CountTokensInClass(D,c)
        prior[c]←Nc/N
        // 将类别c下的文档连接成一个大字符串
        textc←ConcatenateTextOfAllDocsInClass(D,c)
        for each t∈V
            // 计算类c下单词t的出现次数
            Tct←CountTokensOfTerm(textc,t)
        for each t∈V
            //计算P(t|c)
            condprob[t][c]←
    return V,prior,condprob
}

ApplyMultiNomialNB(C,V,prior,condprob,d) {
    // 将文档d中的单词抽取出来，允许重复，如果单词是全新的，在全局单词表V中都
    // 没出现过，则忽略掉
    W←ExtractTokensFromDoc(V,d)
    for each c∈C
        score[c]←prior[c]
        for each t∈W
            if t∈Vd
                score[c] *= condprob[t][c]
    return max(score[c])
}
